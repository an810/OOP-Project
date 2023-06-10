package com.oop2.models;

import java.util.List;
import java.util.Set;

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

        // Close the HTML structure
        htmlBuilder.append("</body>");
        htmlBuilder.append("</html>");

        return htmlBuilder.toString();
    }

    @Override
    public String toString() {
        return  "\n{ \"Id\":\"" + this.id + "\", "
                + "\n\"Địa danh\":\"" + this.name + "\", "
                + "\n\"Code\":\"" + this.historicalDestinationCode + "\", "
                + "\n\"Miêu tả\":\"" + this.description + "\", "
                + "\n\"Nhân vật liên quan code\":\"" + this.historicalFiguresLinked + "\" }" + "\n";
    }
}
