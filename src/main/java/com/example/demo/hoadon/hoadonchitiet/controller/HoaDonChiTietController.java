package com.example.demo.hoadon.hoadonchitiet.controller;

import com.example.demo.hoadon.hoadonchitiet.repository.IHoaDonChiTiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hoa-don-chi-tiet/")
public class HoaDonChiTietController {

    @Autowired
    private IHoaDonChiTiet hoaDonChiTietRepository;

    @GetMapping("hien-thi")
    private String hienThi(Model model) {
        model.addAttribute("listHoaDonChiTiet", hoaDonChiTietRepository.findAll());
        return "hoadon/hoadonchitiet/views";
    }
}
