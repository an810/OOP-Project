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

        });

        Thread thread2 = new Thread(() -> {
            FestivalsCrawler festivalsScraper = new FestivalsCrawler();
            festivalsScraper.createFestivals();
        });

        Thread thread3 = new Thread(() -> {
            HistoricalDestinationsCrawler historicalDestinationsCrawler = new HistoricalDestinationsCrawler();
            historicalDestinationsCrawler.createHistoricalDestination();
        });

        Thread thread4 = new Thread(() -> {
            HistoricalEventsCrawler historicalEventsCrawler = new HistoricalEventsCrawler();
            historicalEventsCrawler.createHistoricalEvents();
        });

        Thread thread5 = new Thread(() -> {
            HistoricalFiguresCrawler historicalFiguresCrawler = new HistoricalFiguresCrawler();
            historicalFiguresCrawler.createHistoricalFigures();
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
