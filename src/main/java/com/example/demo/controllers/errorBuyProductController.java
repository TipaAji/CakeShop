package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class errorBuyProductController {
    @GetMapping("/errorbuyproduct")
    public String showProductSuccess(){
        return "errorbuyproduct";
    }
}
