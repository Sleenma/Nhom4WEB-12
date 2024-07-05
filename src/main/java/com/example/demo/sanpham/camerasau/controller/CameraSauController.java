package com.example.demo.sanpham.camerasau.controller;

import com.example.demo.sanpham.camerasau.entity.CameraSau;
import com.example.demo.sanpham.camerasau.repository.CameraSauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/SanPham/CameraSaus")
public class CameraSauController {

    @Autowired
    private CameraSauRepository cameraSauRepository;

    @GetMapping
    public String hienThi(Model model) {
        model.addAttribute("CamSau", cameraSauRepository.findAll());
        return "sanpham/camerasau";
    }

    @PostMapping("/Add")
    public String add(CameraSau cameraSau) {
        cameraSauRepository.save(cameraSau);
        return "redirect:/SanPham/CameraSaus";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        Optional<CameraSau> optionalCameraSau = cameraSauRepository.findById(id);
        if (optionalCameraSau.isPresent()) {
            model.addAttribute("csau", optionalCameraSau.get());
            model.addAttribute("CamSau", cameraSauRepository.findAll());
            return "sanpham/camerasau";
        } else {
            return "redirect:/SanPham/CameraSaus";
        }
    }


    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        cameraSauRepository.deleteById(id);
        return "redirect:/SanPham/CameraSaus";
    }
}
