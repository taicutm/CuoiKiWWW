package com.example.oncki2.controller;

import com.example.oncki2.model.LopHoc;
import com.example.oncki2.model.SinhVien;
import com.example.oncki2.service.LopHocService;
import com.example.oncki2.service.SinhVienService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sinhvien")
public class SinhVienController {
    private final SinhVienService sinhVienService;
    private final LopHocService lopHocService;


    public SinhVienController(SinhVienService sinhVienService, LopHocService lopHocService) {
        this.sinhVienService = sinhVienService;
        this.lopHocService = lopHocService;
    }
    @GetMapping(value = {"","/"})
    public String getAll(Model model){
        model.addAttribute("dssv",sinhVienService.getAllSinhVien());
        return "SinhVien";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("dslop",lopHocService.getAllLopHoc());
        return "AddSinhVien";
    }
    @PostMapping("/themsv")
    public String addSinhVien(@ModelAttribute SinhVien sinhVien , @RequestParam("maLop") int maLop ){
        LopHoc lopHoc = new LopHoc(maLop);
        sinhVien.setLopHoc(lopHoc);
        sinhVienService.addSinhVien(sinhVien);
        return "redirect:/sinhvien";
    }
    @GetMapping("/edit/{maSV}")
    public String edit(@PathVariable int maSV, Model model){
        model.addAttribute("dslop",lopHocService.getAllLopHoc());
        SinhVien sinhVien = sinhVienService.getSinhVienById(maSV);
        model.addAttribute("sinhvien",sinhVien);
        return "EditSinhVien";
    }
    @PostMapping("/editSinhVien")
    public String editSinhVien(@ModelAttribute SinhVien sinhVien , @RequestParam("maLop") int maLop){
        LopHoc lopHoc = new LopHoc(maLop);
        sinhVien.setLopHoc(lopHoc);
        sinhVienService.updateSinhVien(sinhVien);
        return "redirect:/sinhvien";
    }



    @GetMapping("/delete/{maSV}")
    public String delete(@PathVariable int maSV ){
        sinhVienService.deleteSinhVien(maSV);
        return "redirect:/sinhvien";
    }
    // tìm tên bởi text nhập vô
    @GetMapping("/search")
    public String search(@RequestParam("keyword") String text, Model model){
        model.addAttribute("dssv",sinhVienService.getSinhVienByText(text));
        return "SinhVien";
    }

}
