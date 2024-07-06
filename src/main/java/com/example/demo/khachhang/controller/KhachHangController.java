package com.example.demo.khachhang.controller;

import com.example.demo.khachhang.entity.DiaChi;
import com.example.demo.khachhang.entity.KhachHang;
import com.example.demo.khachhang.repository.DiaCHiRepository;
import com.example.demo.khachhang.repository.KhachHangRepository;
import com.example.demo.khachhang.serive.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class KhachHangController {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private DiaCHiRepository diaCHiRepository;




    @RequestMapping("/khachHang")
    public String hienthitatca(Model model) {
        model.addAttribute("khachHang", khachHangRepository.findAllByDeletedTrue());
//        model.addAttribute("khachHang", khachHangRepository.findAllKhachHangWithDiaChi());
        return "khachhang/khachHang";
    }

    @GetMapping("/khachHang/viewadd")
    public String hienthiadd() {
        return "khachhang/addKhachHang";
    }

    @PostMapping("/khachHang/add")
    public String add(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
        return "redirect:/khachHang";
    }
    @PostMapping("/khachHang/update")
    public String update(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
        return "redirect:/khachHang";
    }

    @GetMapping("/khachHang/detail/{id}")
    public String detail(KhachHang khachHang, @PathVariable("id") UUID id, Model model) {
        model.addAttribute("listKH", khachHangRepository.findById(id).orElse(null));
        model.addAttribute("diaChi", diaCHiRepository.findById(id).orElse(null));
        model.addAttribute("diaChiList",diaCHiRepository.findAll());
        return "khachhang/updateKhachHang";
    }


    @GetMapping("/khachHang/remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        khachHangService.removeKhachHang(id);
        return "redirect:/khachHang";
    }
//@GetMapping("/khachHang/findby")
//    public String findbyTenandSdt(KhachHang khachHang){
//        khachHangRepository.timKhachHangTheoTenVaSDT(khachHang.getTenKH(), khachHang.getSdt());
//    return "khachhang/khachHang";
//}
@GetMapping("/khachHang/findby")
public String findbyTenandSdt(@RequestParam("searchQuery") String searchQuery, Model model) {
    // Tách dữ liệu tìm kiếm vào từng phần
    String tenKH = searchQuery;
    String sdt = searchQuery;

    // Gọi phương thức tìm kiếm từ repository
    List<KhachHang> khachHangs = khachHangRepository.timKhachHangTheoTenVaSDT(tenKH, sdt);

    // Đưa dữ liệu vào model để hiển thị ở view
    model.addAttribute("khachHang", khachHangs);

    // Trả về tên view để hiển thị kết quả tìm kiếm
    return "khachhang/khachHang";
}

}

