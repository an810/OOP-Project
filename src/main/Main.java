package main;

import com.oop2.crawlers.*;
import com.oop2.models.Model;
import com.oop2.util.Config;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Thread thread1 = new Thread(() -> {
            ErasCrawler test = new ErasCrawler();
            List<Model> models = test.crawlPages(Config.ERA_WEBPAGE);
            test.writeModel(Config.ERA_FILENAME, models);
        });

        Thread thread2 = new Thread(() -> {
            FestivalsCrawler festivalsScraper = new FestivalsCrawler();
            String page = Config.FESTIVAL_WEBPAGE;
            String festivalFilename = Config.FESTIVAL_FILENAME;
            List<Model> festivals;
            festivals = festivalsScraper.crawlPages(page);
            festivalsScraper.writeModel(festivalFilename, festivals);
        });

        Thread thread3 = new Thread(() -> {
            HistoricalDestinationsCrawler test2 = new HistoricalDestinationsCrawler();
            List<Model> locationList = test2.crawlPages(Config.HISTORICAL_DESTINATION_WEBPAGE);
            test2.writeModel(Config.HISTORICAL_DESTINATION_FILENAME, locationList);
        });

        Thread thread4 = new Thread(() -> {
            HistoricalEventsCrawler test3 = new HistoricalEventsCrawler();
            List<Model> historicalEvents = test3.crawlPages(Config.EVENT_WEBPAGE);
            test3.writeModel(Config.EVENT_FILENAME, historicalEvents);
        });

        Thread thread5 = new Thread(() -> {
            HistoricalFiguresCrawler test4 = new HistoricalFiguresCrawler();
            List<Model> figures = test4.crawlPages(Config.HISTORICAL_FIGURE_WEBPAGE);
            test4.writeModel(Config.HISTORICAL_FIGURE_FILENAME, figures);
        });

        // Start all threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        // Wait for all threads to finish
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
