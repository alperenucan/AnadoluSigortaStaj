package com.example.internship.controller;

import com.example.internship.model.Connection;
import com.example.internship.service.XLSXReaderService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class NotificationController {

    XLSXReaderService xlsxReaderService = new XLSXReaderService();
    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "C://test//";

    @GetMapping("/upload")
    public String index(Model model) {
        model.addAttribute("connection", new Connection());
        return "form";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes, @ModelAttribute Connection type, Model model) {


        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:status";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            model.addAttribute("connection", type);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "' " + type+ xlsxReaderService.ReadExcel(file));

        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }

        return "redirect:/status";
    }

    @GetMapping("/status")
    public String uploadStatus() {
        return "status";
    }
}