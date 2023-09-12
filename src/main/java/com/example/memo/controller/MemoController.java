package com.example.memo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemoController {

    @RequestMapping ("/")
    public String index() {
        return "index";
    }

}
