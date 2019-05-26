package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryServlet {
    @GetMapping("/dictionary")
    public String showForm() {
        return "search";
    }

    @PostMapping
    public ModelAndView showResult(@RequestParam("word") String newword) {
        Map<String, String> dict = new HashMap<>();
        dict.put("pen", "cái bút");
        dict.put("glasses", "cái kính");
        dict.put("water", "nước");
        dict.put("calculator", "máy tính");
        dict.put("paper", "quyển vở");
        String result = dict.get(newword);
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("newword", newword);
        modelAndView.addObject("result", result);
        return modelAndView;
    }
}

