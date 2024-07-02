package com.example.demo.sanpham.loaisac.controller;

import com.example.demo.sanpham.dophangiai.repository.DoPhanGiaiRepository;
import com.example.demo.sanpham.loaisac.repository.LoaiSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoaiSacController {

    @Autowired
    private LoaiSacRepository loaiSacRepository;

    @GetMapping("SanPham/LoaiSacs")
    public String hienThi(Model model){
        model.addAttribute("LoaiSac",loaiSacRepository.findAll());
        return "sanpham/loaisac";
    }
}
