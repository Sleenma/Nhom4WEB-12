package com.example.demo.sanpham.sanphamchitiet.ram.controller;

import com.example.demo.sanpham.sanphamchitiet.mausac.repository.MauSacRepository;
import com.example.demo.sanpham.sanphamchitiet.ram.repository.RamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RamController {

    @Autowired
    private RamRepository ramRepository;
    @GetMapping("SanPham/Rams")
    public String hienThi(Model model){
        model.addAttribute("Ram",ramRepository.findAll());
        return "sanpham/ram";
    }

}
