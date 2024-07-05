package com.example.demo.sanpham.sanphamchitiet.mausac.controller;

import com.example.demo.sanpham.sanphamchitiet.mausac.repository.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MauSacController {

    @Autowired
    private MauSacRepository mauSacRepository;
    @GetMapping("SanPham/MauSacs")
    public String hienThi(Model model){
        model.addAttribute("MauSac",mauSacRepository.findAll());
        return "sanpham/mausac";
    }
}
