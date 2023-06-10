package com.oop2.models;

import java.util.List;
import java.util.Set;

public class HistoricalFigureModel extends Model
{
    private String code;
    private List<List<String>> infobox;
    private Set<String> historicalFiguresLinked;
    private Set<String> historicalDestinationsLinked;
    private Set<String> erasLinked;


    public HistoricalFigureModel(String name, List<String> description, String code, List<List<String>> infobox
            , Set<String> historicalFiguresLinked, Set<String> historicalDestinationsLinked, Set<String> erasLinked)
    {
        super(name, description);
        setCode(code);
        setInfobox(infobox);
        setHistoricalFiguresLinked(historicalFiguresLinked);
        setHistoricalDestinationsLinked(historicalDestinationsLinked);
        setErasLinked(erasLinked);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setInfobox(List<List<String>> infobox) {
        this.infobox = infobox;
    }

    public void setHistoricalFiguresLinked(Set<String> historicalFiguresLinked) {
        this.historicalFiguresLinked = historicalFiguresLinked;
    }

    public void setHistoricalDestinationsLinked(Set<String> historicalDestinationsLinked) {
        this.historicalDestinationsLinked = historicalDestinationsLinked;
    }

    public void setErasLinked(Set<String> erasLinked) {
        this.erasLinked = erasLinked;
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

        // Add the infobox
        htmlBuilder.append("<h2>Thông tin nhân vật</h2>");
        htmlBuilder.append("<table class=\"table-container\">");
        for (List<String> info : this.infobox) {
            htmlBuilder.append("<tr>");
            if (info.size() == 1) htmlBuilder.append("<th colspan=\"2\">");
            else htmlBuilder.append("<th scope=\"row\">");
            htmlBuilder.append(info.get(0)).append("</th>");
            htmlBuilder.append("<td>");
            for (int i = 1; i < info.size(); i++) {
                if (i > 1) htmlBuilder.append("<br>");
                htmlBuilder.append(info.get(i));
            }
            htmlBuilder.append("</td>");
            htmlBuilder.append("</tr>");
        }
        htmlBuilder.append("</table>");

        // Add the description
        htmlBuilder.append("<h2>Description</h2>");
        for (String desc : this.description) {
            htmlBuilder.append("<p>").append(desc).append("</p>");
        }

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

        // Add the related time periods
        htmlBuilder.append("<h2>Related Time Periods</h2>");
        htmlBuilder.append("<ul>");
        for (String timePeriod : this.erasLinked) {
            htmlBuilder.append("<li>").append(timePeriod).append("</li>");
        }
        htmlBuilder.append("</ul>");

        // Close the HTML structure
        htmlBuilder.append("</body>");
        htmlBuilder.append("</html>");

        return htmlBuilder.toString();
    }
}