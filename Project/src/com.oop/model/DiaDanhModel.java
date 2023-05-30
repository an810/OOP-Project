package com.oop.model;

import java.util.Set;

public class DiaDanhModel extends Model{
    private String description;
    private Set<String> nhanVatLienQuan;
    public DiaDanhModel(String name) {
        super(name);
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getNhanVatLienQuan() {
        return nhanVatLienQuan;
    }

    public void setNhanVatLienQuan(Set<String> nhanVatLienQuan) {
        this.nhanVatLienQuan = nhanVatLienQuan;
    }

    @Override
    public String toString() {
        return "\n{ \"Dia danh\":\"" + super.getName() + "\", "
                + "\n\"Mieu ta\":\"" + this.description + "\", "
                + "\n\"Nhan vat lien quan\":\"" + this.nhanVatLienQuan + "\" }" + "\n";
    }
}
