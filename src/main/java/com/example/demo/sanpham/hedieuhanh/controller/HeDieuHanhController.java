package com.example.demo.sanpham.hedieuhanh.controller;

import com.example.demo.sanpham.hang.repository.HangRepository;
import com.example.demo.sanpham.hedieuhanh.repository.HeDieuHanhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HeDieuHanhController {
    @Autowired
    private HeDieuHanhRepository heDieuHanhRepository;
    @GetMapping("SanPham/HeDieuHanhs")
    public String hienThi(Model model){


        model.addAttribute("HeDieuHanh",heDieuHanhRepository.findAll());

        return "sanpham/hedieuahnh";

    }
}
