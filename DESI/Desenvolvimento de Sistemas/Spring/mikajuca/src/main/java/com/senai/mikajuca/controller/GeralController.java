package com.senai.mikajuca.controller;

import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@Controller
public class GeralController {

    @GetMapping("/main")
    public String hubContratos() {
        return "index";
    }

}
