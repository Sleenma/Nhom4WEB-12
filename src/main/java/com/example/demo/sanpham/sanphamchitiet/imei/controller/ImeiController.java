package com.example.demo.sanpham.sanphamchitiet.imei.controller;

import com.example.demo.sanpham.sanphamchitiet.anhsanpham.repository.AnhSanPhamRepository;
import com.example.demo.sanpham.sanphamchitiet.imei.repository.ImeiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImeiController {


    @Autowired
    private ImeiRepository imeiRepository;
    @GetMapping("SanPham/Imeis")
    public String hienThi(Model model){
        model.addAttribute("Imei",imeiRepository.findAll());
        return "sanpham/anhsanpham";
    }

}
