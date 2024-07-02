package com.example.demo.sanpham.cameratruoc.controller;


import com.example.demo.sanpham.cameratruoc.repository.CameraTruocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CameraTruocController {
    @Autowired
    private CameraTruocRepository cameraTruocRepository;

    @GetMapping("SanPham/CameraTruocs")

    public String hienThi(Model model) {
        model.addAttribute("CamTruoc", cameraTruocRepository.findAll());
        return "sanpham/cameratruoc";
    }

}
