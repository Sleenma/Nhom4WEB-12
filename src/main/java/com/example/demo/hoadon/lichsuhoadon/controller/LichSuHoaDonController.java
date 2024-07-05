package com.example.demo.hoadon.lichsuhoadon.controller;

import com.example.demo.hoadon.lichsuhoadon.repository.ILichSuHoaDon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lich-su-hoa-don/")
public class LichSuHoaDonController {

    @Autowired
    private ILichSuHoaDon lichSuHoaDonRepository;

    @GetMapping("hien-thi")
    private String hienThi(Model model) {
        model.addAttribute("listLichSuHoaDon", lichSuHoaDonRepository.findAll());
        return "hoadon/lichsuhoadon/views";
    }
}
