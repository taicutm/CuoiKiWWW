package com.example.oncki2.service.impl;

import com.example.oncki2.model.LopHoc;
import com.example.oncki2.repository.LopHocRepository;
import com.example.oncki2.service.LopHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LopHocImpl implements LopHocService {

    private final LopHocRepository lopHocRepository;

    @Autowired
    public LopHocImpl(LopHocRepository lopHocRepository) {
        this.lopHocRepository = lopHocRepository;
    }

    @Override
    public void addLopHoc(LopHoc lopHoc) {
        lopHocRepository.save(lopHoc);
    }

    @Override
    public void deleteLopHoc(int id) {
        lopHocRepository.deleteById(id);

    }

    @Override
    public boolean updateLopHoc(LopHoc lopHoc) {
        LopHoc lopHoc1 = lopHocRepository.findById(lopHoc.getMaLop()).orElse(null);
        if (lopHoc1 != null){
            lopHoc1.setTenLop(lopHoc.getTenLop());
            lopHocRepository.save(lopHoc1);
            return true;
        }
        return false;
    }

    @Override
    public LopHoc getLopHocById(int id) {
        return lopHocRepository.findById(id).orElse(null);
    }

    @Override
    public List<LopHoc> getAllLopHoc() {
        return lopHocRepository.findAll();
    }
}
