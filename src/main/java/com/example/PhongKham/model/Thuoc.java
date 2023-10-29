package com.example.PhongKham.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Thuoc {
    private int madonthuoc;
    private int mabenhnhan;
    private String tenthuoc;
    private String donvitinh;
    private int soluong;
    private String cachdung;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayke;

    public Thuoc() {
    }

    public Thuoc(int madonthuoc, int mabenhnhan, String tenthuoc, String donvitinh, int soluong, String cachdung, Date ngayke) {
        this.madonthuoc = madonthuoc;
        this.mabenhnhan = mabenhnhan;
        this.tenthuoc = tenthuoc;
        this.donvitinh = donvitinh;
        this.soluong = soluong;
        this.cachdung = cachdung;
        this.ngayke = ngayke;
    }

    public int getMadonthuoc() {
        return madonthuoc;
    }

    public void setMadonthuoc(int madonthuoc) {
        this.madonthuoc = madonthuoc;
    }

    public int getMabenhnhan() {
        return mabenhnhan;
    }

    public void setMabenhnhan(int mabenhnhan) {
        this.mabenhnhan = mabenhnhan;
    }

    public String getTenthuoc() {
        return tenthuoc;
    }

    public void setTenthuoc(String tenthuoc) {
        this.tenthuoc = tenthuoc;
    }

    public String getDonvitinh() {
        return donvitinh;
    }

    public void setDonvitinh(String donvitinh) {
        this.donvitinh = donvitinh;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getCachdung() {
        return cachdung;
    }

    public void setCachdung(String cachdung) {
        this.cachdung = cachdung;
    }

    public Date getNgayke() {
        return ngayke;
    }

    public void setNgayke(Date ngayke) {
        this.ngayke = ngayke;
    }
}
