package com.example.demo.khachhang.controller;

import com.example.demo.khachhang.entity.DiaChi;
import com.example.demo.khachhang.entity.KhachHang;
import com.example.demo.khachhang.repository.DiaCHiRepository;
import com.example.demo.khachhang.repository.KhachHangRepository;
import com.example.demo.khachhang.serive.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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



    @GetMapping("/khachHang")
    private String hienThi(Model model,
                           @RequestParam(name = "page", defaultValue = "0") Integer page,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        model.addAttribute("keyword", keyword);

        String keyword1 = "%" + keyword + "%";
        Pageable pageable = PageRequest.of(page, 5);
        model.addAttribute("khachHang", khachHangRepository.timKhachHangTheoTenVaSDT(keyword1, keyword1,  pageable));
        return "khachhang/khachHang";
    }

//
//    @RequestMapping("/khachHang")
//    public String hienthitatca(Model model) {
//model.addAttribute("khachHang",khachHangRepository.findAllByDeletedTrue());
//        return "khachhang/khachHang";
//    }

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

}

