package com.example.demo.sanpham.Chip.controller;

import com.example.demo.sanpham.Chip.repository.ChipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChipController {
    @Autowired
    private ChipRepository chipRepository;

    public String hienThi(Model model) {

        model.addAttribute("Chips", chipRepository.findAll());

        return "sanpham/chip";
    }
}
