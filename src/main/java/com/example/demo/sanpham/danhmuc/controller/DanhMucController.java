package com.example.demo.sanpham.danhmuc.controller;

import com.example.demo.sanpham.danhmuc.repository.DanhMucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DanhMucController {
    @Autowired

    private DanhMucRepository danhMucRepository;

    @GetMapping("SanPham/danhmucs")
    public String hienThi(Model model){

        model.addAttribute("DanhMuc",danhMucRepository.findAll());

        return "sanpham/danhmuc";

    }

}
