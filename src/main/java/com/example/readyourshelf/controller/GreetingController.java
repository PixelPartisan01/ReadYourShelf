package com.example.readyourshelf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GreetingController
{
    @GetMapping
    public String greeting(Model model)
    {
        model.addAttribute("message", "Welcome to Read Your Shelf!");
        return "greeting";
    }
}
