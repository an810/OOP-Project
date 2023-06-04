package com.oop.data;

import com.oop.model.ThoiKyModel;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ThoiKyCrawler implements ICrawler {
    @Override
    public void crawl() {
        String baseUrl = "https://nguoikesu.com/dong-lich-su";
        List<ThoiKyModel> thoiKyModelList = new ArrayList<>();
        Document doc;
        try {
            doc = (Document) Jsoup
                    .connect(baseUrl)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Lay tat cac link can scrape
        List<String> links = new ArrayList<>();
        Element linkElement = doc.selectFirst("div.ja-module#Mod88");
        Elements refElement = linkElement.select("a");
        for(Element element : refElement) {
            String refUrl = element.attr("href");
            links.add("https://nguoikesu.com" + refUrl);
        }

        System.out.println(links);
//         Truy cap vao tung link
//        for (String link : links) {
//
//        }



    }

    // Testing
    public static void main(String[] args) {
        ThoiKyCrawler test = new ThoiKyCrawler();
        test.crawl();
    }

}

