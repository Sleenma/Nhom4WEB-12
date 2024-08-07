package com.example.demo.hoadon.hoadon.controller;

import com.example.demo.hoadon.hoadon.entity.HoaDon;
import com.example.demo.hoadon.hoadon.repository.IHoaDon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/hoa-don/")
public class HoaDonController {

    @Autowired
    private IHoaDon hoaDonRepository;

    @GetMapping("hien-thi")
    private String hienThi(Model model,
                           @RequestParam(name = "page", defaultValue = "0") Integer page,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        model.addAttribute("keyword", keyword);

        String keyword1 = "%" + keyword + "%";
        Pageable pageable = PageRequest.of(page, 2);
        model.addAttribute("listHoaDon", hoaDonRepository.search(keyword1, keyword1, keyword1, pageable));
        return "hoadon/viewhoadon/views";
    }

    @PostMapping("add")
    private String add(HoaDon hoaDon) {
        hoaDonRepository.save(hoaDon);
        return "redirect:/hoa-don/hien-thi";
    }

    @PostMapping("update")
    private String update(HoaDon hoaDon) {
        hoaDonRepository.save(hoaDon);
        return "redirect:/hoa-don/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("hoaDon", hoaDonRepository.findById(id).get());
        model.addAttribute("listHoaDon", hoaDonRepository.findAll());
        return "hoadon/viewhoadon/views";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        hoaDonRepository.deleteById(id);
        return "redirect:/hoa-don/hien-thi";
    }
}
