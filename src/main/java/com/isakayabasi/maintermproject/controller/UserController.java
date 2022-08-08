package com.isakayabasi.maintermproject.controller;

import com.isakayabasi.maintermproject.service.Service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private IUserService iUserService;

    public UserController(IUserService iUserService) {
        super();
        this.iUserService = iUserService;
    }

    //handler method to handle list
    @GetMapping("/user")
    public String listStudents(Model model){
        model.addAttribute("users",iUserService.getAllUsers());
        return "user.html";
    }

}