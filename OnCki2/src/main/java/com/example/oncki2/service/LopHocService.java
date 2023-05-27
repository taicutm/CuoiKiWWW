package com.example.oncki2.service;

import com.example.oncki2.model.LopHoc;

import java.util.List;

public interface LopHocService {
    void addLopHoc(LopHoc lopHoc);
    void deleteLopHoc(int id);
    boolean updateLopHoc(LopHoc lopHoc);
    LopHoc getLopHocById(int id);
    List<LopHoc> getAllLopHoc();
}
