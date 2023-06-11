package com.oop2.crawlers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.oop2.interfaces.ICrawler;
import com.oop2.models.EraModel;
import com.oop2.models.HistoricalDestination;
import com.oop2.models.Model;
import com.oop2.superCrawler.SCrawler;
import com.oop2.util.Config;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static com.oop2.util.UrlDecode.getCodeFromUrl;

public class HistoricalDestinationsCrawler extends SCrawler implements ICrawler {
    @Override
    public List<Model> crawlPages(String page) {
        String baseUrl = page;
        // List
        List<Model> destinationList = new ArrayList<>();
        Document doc;
        try {
            doc =  Jsoup
                    .connect(baseUrl)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")
                    .get();
        } catch (IOException e ){
            throw new RuntimeException(e);
        }

        Elements nextElements = doc.select("a.btn.btn-sm.btn-secondary.next");
        String completeUrl = "";

        // Looking for the "Next"
        int id = 0;
        while (baseUrl.compareTo(completeUrl) != 0 && (!nextElements.isEmpty())) {
            // Getting the "Next"
            Element nextElement = nextElements.first();
            // Extracting the relative URL of the next page
            String relativeUrl = nextElement.attr("href");
            completeUrl = "https://nguoikesu.com" + relativeUrl;
            // Debugger
            System.out.println(completeUrl);
            int maxRetries = 3;
            int retryCount = 0;
            boolean success = false;

            while (!success && retryCount < maxRetries) {
                try {
                    doc = Jsoup
                            .connect(completeUrl)
                            .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")
                            .get();

                    success = true; // Request succeeded
                } catch (IOException e) {
                    System.out.println("Request failed. Retrying...");
                    retryCount++;

                    // Wait for a short duration before retrying
                    try {
                        Thread.sleep(1000); // Adjust the delay as needed
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }

            if (!success) {
                throw new RuntimeException("Exceeded maximum retries. Request failed.");
            }


            // Collect data
            // Get title
            String title = null;
            Element titleElement = doc.selectFirst("h2");
            if (titleElement != null) {
                 title = titleElement.text();
            }

            List<String> texts = new ArrayList<>();

            Elements desElements = doc.select("div.com-content-article__body > p");
            for(Element element : desElements) {
                String text = element.text();
                if (text.length() > 50) {
                    text = text.replaceAll("\"", "'");

                    texts.add(text);
                    break;
                }
            }

            // Relative person
            Set<String> nhanVatLienQuan = new HashSet<>();
            Elements refElements = desElements.select("a[href*=/nhan-vat/]");
            for (Element refElement : refElements) {
                String name = refElement.attr("href");
                nhanVatLienQuan.add(getCodeFromUrl(name));
            }

            Model destination =  new HistoricalDestination(title, texts, getCodeFromUrl(completeUrl), nhanVatLienQuan);
            destination.setId(++id);
            destinationList.add(destination);
            nextElements = doc.select("a.btn.btn-sm.btn-secondary.next");
        }

        return destinationList;
    }

    @Override
    public void writeJson(String fileName, List<Model> models)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        String json = gson.toJson(models);
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createHistoricalDestinationJson()
    {
        List<Model> locationList = crawlPages(Config.HISTORICAL_DESTINATION_WEBPAGE);
        writeJson(Config.HISTORICAL_DESTINATION_FILENAME, locationList);
    }

    // Testing
    public static void main(String[] args) {
//        HistoricalDestinationsCrawler test = new HistoricalDestinationsCrawler();
//        List<Model> locationList = test.crawlPages(Config.HISTORICAL_DESTINATION_WEBPAGE);
//        test.writeJson(Config.HISTORICAL_DESTINATION_FILENAME, locationList);
//        test.writeHTML(Config.HISTORICAL_DESTINATION_HTML, locationList);

        HistoricalDestinationsCrawler test = new HistoricalDestinationsCrawler();
        List<EraModel> myList = test.loader(Config.HISTORICAL_DESTINATION_FILENAME,  new TypeToken<List<EraModel>>() {});
        List<Model> newList = new ArrayList<>();
        newList.addAll(myList);
        test.writeHTML(Config.HISTORICAL_DESTINATION_HTML, newList);
    }
}
