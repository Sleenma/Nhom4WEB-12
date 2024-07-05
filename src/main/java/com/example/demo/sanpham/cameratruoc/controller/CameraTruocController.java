package com.example.demo.sanpham.cameratruoc.controller;


import com.example.demo.sanpham.camerasau.entity.CameraSau;
import com.example.demo.sanpham.cameratruoc.entity.CameraTruoc;
import com.example.demo.sanpham.cameratruoc.repository.CameraTruocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/SanPham/CameraTruocs")
public class CameraTruocController {
    @Autowired
    private CameraTruocRepository cameraTruocRepository;

    @GetMapping
    public String hienThi(Model model) {
        model.addAttribute("CamTruoc", cameraTruocRepository.findAll());
        return "sanpham/cameratruoc";
    }
    @PostMapping("/Add")
    public String add(CameraTruoc cameraTruoc) {
        cameraTruocRepository.save(cameraTruoc);
        return "redirect:/SanPham/CameraTruocs";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        Optional<CameraTruoc> optionalCameraSau = cameraTruocRepository.findById(id);
        if (optionalCameraSau.isPresent()) {
            model.addAttribute("ctruoc", optionalCameraSau.get());
            model.addAttribute("CamTruoc", cameraTruocRepository.findAll());
            return "sanpham/cameratruoc";
        } else {
            return "redirect:/SanPham/CameraTruocs";
        }
    }


    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        cameraTruocRepository.deleteById(id);
        return "redirect:/SanPham/CameraTruocs";
    }
}
