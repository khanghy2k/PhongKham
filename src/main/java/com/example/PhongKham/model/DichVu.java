package com.example.PhongKham.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class DichVu {
    private int MaDichVu;
    @NotEmpty(message = " Tên Dịch Vụ Không được để trống")
    private String TenDichVu;
    @NotEmpty(message = " Mô Tả Không được để trống")
    private String mota;
    @Min(value = 0 , message = " Giá không được âm")
    private Integer gia;

    public DichVu() {
    }

    public DichVu(int maDichVu, String tenDichVu, String mota, Integer gia) {
        MaDichVu = maDichVu;
        TenDichVu = tenDichVu;
        this.mota = mota;
        this.gia = gia;
    }

    public int getMaDichVu() {
        return MaDichVu;
    }

    public void setMaDichVu(int maDichVu) {
        MaDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return TenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        TenDichVu = tenDichVu;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }
}
