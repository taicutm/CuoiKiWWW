package com.example.oncki2;

import com.example.oncki2.model.LopHoc;
import com.example.oncki2.model.SinhVien;
import com.example.oncki2.repository.LopHocRepository;
import com.example.oncki2.repository.SinhVienRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnCki2Application {

    public static void main(String[] args) {
        SpringApplication.run(OnCki2Application.class, args);
    }

   // @Bean
    public CommandLineRunner start(SinhVienRepository sinhVienRepository , LopHocRepository lopHocRepository){
        return args -> {
             LopHoc lopHoc1 = new LopHoc("DHKTPM16A");
             LopHoc lopHoc2 = new LopHoc("DHKTPM16B");
             lopHocRepository.save(lopHoc1);
             lopHocRepository.save(lopHoc2);

             SinhVien sinhVien1 = new SinhVien("Nguyen Van A",lopHoc1);
             SinhVien sinhVien2 = new SinhVien("Nguyen Van B",lopHoc1);
             SinhVien sinhVien3 = new SinhVien("Nguyen Van C",lopHoc2);
             SinhVien sinhVien4 = new SinhVien("Nguyen Van D",lopHoc2);
             sinhVienRepository.save(sinhVien1);
             sinhVienRepository.save(sinhVien2);
             sinhVienRepository.save(sinhVien3);
             sinhVienRepository.save(sinhVien4);
        };
    }

}
