package com.BlogBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class giDefaultController {

    @GetMapping
    public String index(){
        return "index";
    }
}
