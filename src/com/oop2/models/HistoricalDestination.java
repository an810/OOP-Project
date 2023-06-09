package com.oop2.models;

import java.util.*;


public class HistoricalDestination extends Model{
    private String historicalDestinationCode;
    private Set<String> historicalFiguresLinked;
    public HistoricalDestination(String name, List<String> description, String historicalDestinationCode, Set<String> historicalFiguresLinked)
    {
        super(name, description);
        setHistoricalDestinationCode(historicalDestinationCode);
        setHistoricalFiguresLinked(historicalFiguresLinked);
    }

    public void setHistoricalFiguresLinked(Set<String> historicalFiguresLinked)
    {
        this.historicalFiguresLinked = historicalFiguresLinked;
    }

    public void setHistoricalDestinationCode(String historicalDestinationCode)
    {
        this.historicalDestinationCode = historicalDestinationCode;
    }

    public String getHistoricalDestinationCode() {
        return historicalDestinationCode;
    }

    public Set<String> getHistoricalFiguresLinked() {
        return historicalFiguresLinked;
    }

    @Override
    public String toString() {
        return  "\n{ \"id\":\"" + this.id + "\", "
                + "\n\"name\":\"" + this.name + "\", "
                + "\n\"historcalDestinationCode\":\"" + this.historicalDestinationCode + "\", "
                + "\n\"description\":\"" + this.description + "\", "
                + "\n\"hisotricalFiguresLinked\":\"" + this.historicalFiguresLinked + "\" }" + "\n";
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
        for (String desc : getDescription()) {
            htmlBuilder.append("<p>").append(desc).append("</p>");
        }

        // Add the related figures
        htmlBuilder.append("<h2>Related Figures</h2>");
        htmlBuilder.append("<ul>");
        for (String figure : getHistoricalFiguresLinked()) {
            htmlBuilder.append("<li>").append(figure).append("</li>");
        }
        htmlBuilder.append("</ul>");

        // Close the HTML structure
        htmlBuilder.append("</body>");
        htmlBuilder.append("</html>");

        return htmlBuilder.toString();
    }
}
