package com.example.internship.controller;

import com.example.internship.model.File;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FileController {

//    @GetMapping("/")
//    public String getType(Model model) {
//        model.addAttribute("connection", new File());
//        return "upload";
//    }
//
//    @PostMapping("/upload")
//    public String selectType(@ModelAttribute File file, Model model) {
//        model.addAttribute("connection", file);
//        return "uploadStatus";
//    }
}
