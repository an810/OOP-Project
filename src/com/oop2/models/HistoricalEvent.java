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

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getBattleResult() {
        return battleResult;
    }

    public Set<String> getHistoricalFiguresLinked() {
        return historicalFiguresLinked;
    }

    public Set<String> getHistoricalDestinationsLinked() {
        return historicalDestinationsLinked;
    }

    @Override
    public String toString() {
        return  "\n{ \"id\":\"" + this.id + "\", "
                + "\n\"name\":\"" + this.name + "\", "
                + "\n\"time\":\"" + this.time + "\", "
                + "\n\"location\":\"" + this.location + "\", "
                + "\n\"battleResult\":\"" + this.battleResult + "\", "
                + "\n\"historicalFiguresLinked\":\"" + this.historicalFiguresLinked + "\", "
                + "\n\"historicalDestinationLinked\":\"" + this.historicalDestinationsLinked + "\" }" + "\n";
    }

    public String toHtml() {
        StringBuilder htmlBuilder = new StringBuilder();

        // Start the HTML structure
        htmlBuilder.append("<html>");
        htmlBuilder.append("<i>").append(getName()).append("</i>");
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
        htmlBuilder.append("<p>").append(getTime()).append("</p>");
        htmlBuilder.append("<p>").append(getLocation()).append("</p>");
        htmlBuilder.append("<p>").append(getBattleResult()).append("</p>");
        

        // Add the related figures
        htmlBuilder.append("<h2>Related Figures</h2>");
        htmlBuilder.append("<ul>");
        for (String figure : getHistoricalFiguresLinked()) {
            htmlBuilder.append("<li>").append(figure).append("</li>");
        }
        htmlBuilder.append("</ul>");

        // Add the related places
        htmlBuilder.append("<h2>Related Places</h2>");
        htmlBuilder.append("<ul>");
        for (String place : getHistoricalDestinationsLinked()) {
            htmlBuilder.append("<li>").append(place).append("</li>");
        }
        htmlBuilder.append("</ul>");

        // Close the HTML structure
        htmlBuilder.append("</body>");
        htmlBuilder.append("</html>");

        return htmlBuilder.toString();
    }
}
