package com.example.internship.controller;

import com.example.internship.model.User;
import com.example.internship.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

   @GetMapping
   public List<User> getUsers(){
      return userService.getUsers();
   }

    @PostMapping("/id/save")
    public RedirectView saveId(User user,
                                 @RequestParam("file") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        return new RedirectView("/users", true);
    }
}
