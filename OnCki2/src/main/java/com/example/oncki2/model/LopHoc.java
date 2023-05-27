package com.example.oncki2.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "lophoc")
public class LopHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maLop;
    private String tenLop;
    @OneToMany(mappedBy = "lopHoc")
    private List<SinhVien> sinhViens;

    public LopHoc() {
    }

    public LopHoc(String tenLop) {
        this.tenLop = tenLop;
    }

    public LopHoc(String tenLop, List<SinhVien> sinhViens) {
        this.tenLop = tenLop;
        this.sinhViens = sinhViens;
    }

    public LopHoc(int maLop) {
        this.maLop = maLop;
    }

    public int getMaLop() {
        return maLop;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public List<SinhVien> getSinhViens() {
        return sinhViens;
    }

    public void setSinhViens(List<SinhVien> sinhViens) {
        this.sinhViens = sinhViens;
    }

    @Override
    public String toString() {
        return "LopHoc{" +
                "maLop=" + maLop +
                ", tenLop='" + tenLop + '\'' +
                ", sinhViens=" + sinhViens +
                '}';
    }
}
