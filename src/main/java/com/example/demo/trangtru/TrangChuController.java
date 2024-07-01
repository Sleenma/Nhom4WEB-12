package com.example.demo.trangtru;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrangChuController {
    @GetMapping("/")
    public String hienThi(){

        return "layout/in";
    }
}
