package com.oop.data;

import com.oop.model.ThoiKyModel;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.oop.util.UrlDecode.getCodeFromUrl;

public class ThoiKyCrawler implements ICrawler {
    @Override
    public void crawl() {
        String baseUrl = "https://nguoikesu.com/dong-lich-su";
        List<ThoiKyModel> thoiKyList = new ArrayList<>();
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
//        String[] skipLinks = {"bac-thuoc-lan-thu-nhat", "nha-ly-va-nha-trieu", "thoi-ky-xay-nen-tu-chu",
//                                "nam-bac-trieu", "trinh-nguyen-phan-tranh", "phap-thuoc", "viet-nam-dan-chu-cong-hoa"};
        Element linkElement = doc.selectFirst("div.ja-module#Mod88");
        Elements refElement = linkElement.select("a");
        for(Element element : refElement) {
            String refUrl = element.attr("href");
//            boolean check = true;
//            for (String skip : skipLinks) {
//                if (getCodeFromUrl(refUrl).equals(skip)) {
//                    check = false;
//                    break;
//                }
//            }
//            if(!check) continue;
            links.add("https://nguoikesu.com" + refUrl);
        }

        System.out.println(links);
//         Truy cap vao tung link
        for (String link : links) {
            try {
                doc = (Document) Jsoup
                        .connect(link)
                        .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")
                        .get();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Element tenThoiKy = doc.selectFirst("h1");
            System.out.println(tenThoiKy.text());
            ThoiKyModel thoiKy = new ThoiKyModel(tenThoiKy.text());
            Elements des = doc.select("div.category-desc");
            thoiKy.setDescription(des.text());

            // Lay nhan vat lien quan
            Set<String> nhanVatLienQuan = new HashSet<>();
            Elements nextPage = doc.select("div.com-content-category-blog__pagination");
            // Check link co gom nhieu trang con khong
            if (nextPage.size() == 0) {
                nhanVatLienQuan = get1(tenThoiKy.text(),link);
                thoiKy.setNhanVatLienQuan(nhanVatLienQuan);
            } else {
                nhanVatLienQuan = get2(tenThoiKy.text(), link);
                thoiKy.setNhanVatLienQuan(nhanVatLienQuan);
            }
            thoiKyList.add(thoiKy);
        }
    }

    // Lay thong tin nhan vat tu trang don
    public static Set<String> get1(String tenThoiKy, String url) {
        Set<String> nhanVatLienQuan = new HashSet<>();
        Document doc;
        try {
            doc = Jsoup
                    .connect(url)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Elements links = doc.select("div.item-content");
        for (Element link : links) {
            Element element = link.selectFirst("h2");
            String urlCrawl = element.attr("href");
            System.out.println(urlCrawl);
            Element title = link.selectFirst("dd.category-name");
            if (title.text().equals(tenThoiKy)) {
                try {
                    doc = Jsoup
                            .connect("https://nguoikesu.com" + urlCrawl)
                            .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")
                            .get();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return nhanVatLienQuan;
    }

    // Lay thong tin nhan vat tu trang gom nhieu trang con
    public static Set<String> get2(String tenThoiKy, String url) {
        Set<String> nhanVatLienQuan = new HashSet<>();
        Document doc;
        try {
            doc = Jsoup
                    .connect(url)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return nhanVatLienQuan;
    }


    // Testing
    public static void main(String[] args) {
        ThoiKyCrawler test = new ThoiKyCrawler();
        test.crawl();
    }

}

