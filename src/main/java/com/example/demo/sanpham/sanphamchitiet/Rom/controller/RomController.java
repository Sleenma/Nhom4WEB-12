package com.example.demo.sanpham.sanphamchitiet.Rom.controller;

import com.example.demo.sanpham.sanphamchitiet.Rom.repository.RomRepository;
import com.example.demo.sanpham.sanphamchitiet.mausac.repository.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RomController {

    @Autowired
    private RomRepository romRepository;
    @GetMapping("SanPham/Roms")
    public String hienThi(Model model){
        model.addAttribute("Rom",romRepository.findAll());
        return "sanpham/rom";
    }
}
