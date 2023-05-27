package com.example.oncki2.repository;

import com.example.oncki2.model.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Integer> {
    // find sinh vien by text
    @Query(value = "SELECT * FROM sinhvien WHERE ho_ten LIKE %?1%", nativeQuery = true)
    List<SinhVien> findSinhVienByText(String text);
}
