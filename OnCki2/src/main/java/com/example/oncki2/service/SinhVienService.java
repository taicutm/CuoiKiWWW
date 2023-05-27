package com.example.oncki2.service;

import com.example.oncki2.model.SinhVien;

import java.util.List;

public interface SinhVienService  {
    void addSinhVien(SinhVien sinhVien);
    void deleteSinhVien(int id);
    boolean updateSinhVien(SinhVien sinhVien);
    SinhVien getSinhVienById(int id);
    List<SinhVien> getAllSinhVien();
    List<SinhVien> getSinhVienByText(String text);
}
