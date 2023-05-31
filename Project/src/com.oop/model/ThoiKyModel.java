package com.oop.model;

public class ThoiKyModel extends Model{
    private String description;
    ThoiKyModel(String ten) {
        super(ten);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "\n{ \"Tên thời kỳ\":\"" + super.getTen() + "\", "
                + "\n\"Miêu tả\":\"" + this.description + "\" }" + "\n";
    }
}
