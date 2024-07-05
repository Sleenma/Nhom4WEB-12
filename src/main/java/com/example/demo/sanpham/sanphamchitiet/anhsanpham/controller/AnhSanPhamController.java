package com.example.demo.sanpham.sanphamchitiet.anhsanpham.controller;

import com.example.demo.sanpham.sanphamchitiet.anhsanpham.repository.AnhSanPhamRepository;
import com.example.demo.sanpham.thenho.repository.TheNhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnhSanPhamController {

    @Autowired
    private AnhSanPhamRepository anhSanPhamRepository;
    @GetMapping("SanPham/AnhSanPhams")
    public String hienThi(Model model){
        model.addAttribute("AnhSanPham",anhSanPhamRepository.findAll());
        return "sanpham/anhsanpham";
    }
}
