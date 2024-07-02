package com.example.demo.sanpham.hang.controller;

import com.example.demo.sanpham.hang.repository.HangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HangController {


    @Autowired
    private HangRepository hangRepository;
    @GetMapping("SanPham/Hangs")
    public String hienThi(Model model){


        model.addAttribute("Hang",hangRepository.findAll());

        return "sanpham/hang";

    }

}
