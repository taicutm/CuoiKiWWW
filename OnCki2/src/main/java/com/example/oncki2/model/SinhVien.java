package com.example.oncki2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sinhvien")
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int masv;
    private String hoTen;
    @ManyToOne
    @JoinColumn(name = "maLop")
    private LopHoc lopHoc;

    public SinhVien() {
    }

    public SinhVien(String hoTen, LopHoc lopHoc) {
        this.hoTen = hoTen;
        this.lopHoc = lopHoc;
    }

    public int getMasv() {
        return masv;
    }

    public void setMasv(int masv) {
        this.masv = masv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LopHoc getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(LopHoc lopHoc) {
        this.lopHoc = lopHoc;
    }
}
