package com.example.oncki2.service.impl;

import com.example.oncki2.model.SinhVien;
import com.example.oncki2.repository.SinhVienRepository;
import com.example.oncki2.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinhVienImpl implements SinhVienService {

    private  final SinhVienRepository sinhVienRepository;

    @Autowired
    public SinhVienImpl(SinhVienRepository sinhVienRepository) {
        this.sinhVienRepository = sinhVienRepository;
    }

    @Override
    public void addSinhVien(SinhVien sinhVien) {
        sinhVienRepository.save(sinhVien);
    }

    @Override
    public void deleteSinhVien(int id) {
        sinhVienRepository.deleteById(id);
    }

    @Override
    public boolean updateSinhVien(SinhVien sinhVien) {
        SinhVien sinhVien1 = sinhVienRepository.findById(sinhVien.getMasv()).orElse(null);
        if (sinhVien1 != null){
            sinhVien1.setMasv(sinhVien.getMasv());
            sinhVien1.setHoTen(sinhVien.getHoTen());
            sinhVienRepository.save(sinhVien1);
            return true;
        }
        return false;
    }

    @Override
    public SinhVien getSinhVienById(int id) {
        return sinhVienRepository.findById(id).orElse(null);
    }

    @Override
    public List<SinhVien> getAllSinhVien() {
        return sinhVienRepository.findAll();
    }

    @Override
    public List<SinhVien> getSinhVienByText(String text) {
        return sinhVienRepository.findSinhVienByText(text);
    }
}
