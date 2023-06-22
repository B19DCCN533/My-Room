package com.example.myroom;

import java.io.Serializable;

public class RoomInfomation implements Serializable {
    // khai báo các thuộc tính của lớp thông tin phòng
    private int id;
    private String hovaten;
    private String ngaysinh;
    private String sodienthoai;
    private String cmnd;
    private String ngaythue;
    private String tenphong;
    private int tienphong;
    private int tiendichvu;
    private int tiendien;
    private int tiennuoc;
    private String ghichu;
    private String ngaytao;
    // khai báo các hàm khởi tạo
    public RoomInfomation(String hovaten, String ngaysinh, String sodienthoai, String cmnd, String ngaythue, String tenphong, int tienphong, int tiendichvu, int tiendien, int tiennuoc,String ghichu) {
        this.hovaten = hovaten;
        this.ngaysinh = ngaysinh;
        this.sodienthoai = sodienthoai;
        this.cmnd = cmnd;
        this.ngaythue = ngaythue;
        this.tenphong = tenphong;
        this.tienphong = tienphong;
        this.tiendichvu = tiendichvu;
        this.tiendien = tiendien;
        this.tiennuoc = tiennuoc;
        this.ghichu=ghichu;
    }
    public RoomInfomation(int id,String hovaten, String ngaysinh, String sodienthoai, String cmnd, String ngaythue, String tenphong, int tienphong, int tiendichvu, int tiendien, int tiennuoc) {
        this.id=id;
        this.hovaten = hovaten;
        this.ngaysinh = ngaysinh;
        this.sodienthoai = sodienthoai;
        this.cmnd = cmnd;
        this.ngaythue = ngaythue;
        this.tenphong = tenphong;
        this.tienphong = tienphong;
        this.tiendichvu = tiendichvu;
        this.tiendien = tiendien;
        this.tiennuoc = tiennuoc;
    }

    public RoomInfomation(String hovaten, String tenphong, int tienphong, int tiendichvu, int tiendien, int tiennuoc,String ngaytao) {
        this.hovaten = hovaten;
        this.tenphong = tenphong;
        this.tienphong = tienphong;
        this.tiendichvu = tiendichvu;
        this.tiendien = tiendien;
        this.tiennuoc = tiennuoc;
        this.ngaytao=ngaytao;
    }
    // tạo các hàm get, set để hiển thị thông tin
    public String getNgaytao() {
        return ngaytao;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getNgaythue() {
        return ngaythue;
    }

    public void setNgaythue(String ngaythue) {
        this.ngaythue = ngaythue;
    }

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }

    public int getTienphong() {
        return tienphong;
    }

    public void setTienphong(int tienphong) {
        this.tienphong = tienphong;
    }

    public int getTiendichvu() {
        return tiendichvu;
    }

    public void setTiendichvu(int tiendichvu) {
        this.tiendichvu = tiendichvu;
    }

    public int getTiendien() {
        return tiendien;
    }

    public void setTiendien(int tiendien) {
        this.tiendien = tiendien;
    }

    public int getTiennuoc() {
        return tiennuoc;
    }

    public void setTiennuoc(int tiennuoc) {
        this.tiennuoc = tiennuoc;
    }
}
