package com.oop2.superCrawler;

import com.oop2.models.Model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public abstract class SCrawler
{
    public void writeHTML(String fileName, List<Model> models)
    {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Model model : models)
            {
                writer.write(model.toHTML() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
