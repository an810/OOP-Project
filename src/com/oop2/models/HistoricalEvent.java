package com.oop2.models;

import java.util.Set;
import java.util.List;

public class HistoricalEvent extends Model {
    private String time;
    private String location;
    private String battleResult;
    private Set<String> historicalFiguresLinked;
    private Set<String> historicalDestinationsLinked;

    public HistoricalEvent(String name, List<String> description, String time, String location, String battleResult
            , Set<String> historicalFiguresLinked, Set<String> historicalDestinationsLinked) {
        super(name, description);
        setTime(time);
        setLocation(location);
        setBattleResult(battleResult);
        setHistoricalFiguresLinked(historicalFiguresLinked);
        setHistoricalDestinationsLinked(historicalDestinationsLinked);
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBattleResult(String battleResult) {
        this.battleResult = battleResult;
    }

    public void setHistoricalFiguresLinked(Set<String> historicalFiguresLinked) {
        this.historicalFiguresLinked = historicalFiguresLinked;
    }

    public void setHistoricalDestinationsLinked(Set<String> historicalDestinationsLinked) {
        this.historicalDestinationsLinked = historicalDestinationsLinked;
    }

    @Override
    public String toHTML() {
        StringBuilder htmlBuilder = new StringBuilder();

        // Start the HTML structure
        htmlBuilder.append("<html>");
        htmlBuilder.append("<i>").append(this.name).append("</i>");
        htmlBuilder.append("<head>");
        htmlBuilder.append("</head>");
        htmlBuilder.append("<body contenteditable=\"true\">");
        htmlBuilder.append("<meta charset=\"UTF-8\">");
        // htmlBuilder.append("<title>").append(getName()).append("</title>");
        htmlBuilder.append("<style>");
        htmlBuilder.append("body { font-family:'lucida grande', tahoma, verdana, arial, sans-serif;font-size:14px; }");
        htmlBuilder.append("table { font-family:'lucida grande', tahoma, verdana, arial, sans-serif;font-size:14px; }");
        htmlBuilder.append(".table-container { text-align: left; }");
        htmlBuilder.append("</style>");



        // Add the name as a heading
        // htmlBuilder.append("<h1>").append("NHÂN VẬT").append("</h1>");
        // htmlBuilder.append("<h1>").append(getName()).append("</h1>");

        // Add the code
        // htmlBuilder.append("<p><strong>Code:</strong> ").append(getCode()).append("</p>");


        // Add the description
        htmlBuilder.append("<h2>Description</h2>");
        htmlBuilder.append("<p>").append(this.time).append("</p>");
        htmlBuilder.append("<p>").append(this.location).append("</p>");
        htmlBuilder.append("<p>").append(this.battleResult).append("</p>");


        // Add the related figures
        htmlBuilder.append("<h2>Related Figures</h2>");
        htmlBuilder.append("<ul>");
        for (String figure : this.historicalFiguresLinked) {
            htmlBuilder.append("<li>").append(figure).append("</li>");
        }
        htmlBuilder.append("</ul>");

        // Add the related places
        htmlBuilder.append("<h2>Related Places</h2>");
        htmlBuilder.append("<ul>");
        for (String place : this.historicalDestinationsLinked) {
            htmlBuilder.append("<li>").append(place).append("</li>");
        }
        htmlBuilder.append("</ul>");

        // Close the HTML structure
        htmlBuilder.append("</body>");
        htmlBuilder.append("</html>");

        return htmlBuilder.toString();
    }

    @Override
    public String toString() {
        return  "\n{ \"Id\":\"" + this.id + "\", "
                + "\n\"Tên\":\"" + this.name + "\", "
                + "\n\"Thời gian\":\"" + this.time + "\", "
                + "\n\"Địa điểm\":\"" + this.location + "\", "
                + "\n\"kết quả\":\"" + this.battleResult + "\", "
                + "\n\"Nhân vật liên quan code\":\"" + this.historicalFiguresLinked + "\", "
                + "\n\"Địa điểm liên quan code\":\"" + this.historicalDestinationsLinked + "\" }" + "\n";
    }
}
