package com.example.demo.sanpham.dophangiai.controller;


import com.example.demo.sanpham.dophangiai.repository.DoPhanGiaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoPhanGiaiController {

    @Autowired
    private DoPhanGiaiRepository doPhanGiaiRepository;

    @GetMapping("SanPham/DoPhanGiais")
    public String hienThi(Model model){
        model.addAttribute("DoPhanGiai",doPhanGiaiRepository.findAll());
        return "sanpham/dophangiai";
    }

}
