package com.oop.model;

import java.util.Set;

public class SuKienModel extends Model {
    private String thoiGian;
    private String diaDiem;
    private String ketQua;
    private Set<String> nhanVatLienQuan;
    private Set<String> diaDiemLienQuan;

    public SuKienModel(String name) {
        super(name);
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }

    public Set<String> getNhanVatLienQuan() {
        return nhanVatLienQuan;
    }

    public void setNhanVatLienQuan(Set<String> nhanVatLienQuan) {
        this.nhanVatLienQuan = nhanVatLienQuan;
    }

    public Set<String> getDiaDiemLienQuan() {
        return diaDiemLienQuan;
    }

    public void setDiaDiemLienQuan(Set<String> diaDiemLienQuan) {
        this.diaDiemLienQuan = diaDiemLienQuan;
    }


}
