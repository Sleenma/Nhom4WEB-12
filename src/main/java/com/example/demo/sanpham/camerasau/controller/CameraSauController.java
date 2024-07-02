package com.example.demo.sanpham.camerasau.controller;

import com.example.demo.sanpham.camerasau.repository.CameraSauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CameraSauController {
    @Autowired
    private CameraSauRepository cameraSauRepository;

    @GetMapping("SanPham/CameraSaus")

    public String hienThi(Model model) {

        model.addAttribute("CamSau", cameraSauRepository.findAll());

        return "sanpham/camerasau";
    }
}
