package com.isakayabasi.maintermproject.controller;

import com.isakayabasi.maintermproject.model.User;
import com.isakayabasi.maintermproject.repository.IUserRepository;
import com.isakayabasi.maintermproject.service.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    IUserRepository iUserRepository;
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
///////////////////////////////////////////////////////////////////////////////
    @PostMapping("/users/{id}")
    public String updateUser(@PathVariable Long id,
                                @ModelAttribute("user") User user, Model model ){
        // get user from database by id
        User existingUser = iUserService.getUserById(id);
        existingUser.setActiveOrPassive(!existingUser.isActiveOrPassive());


        //save updated user object
        iUserService.updateUser(existingUser);
        return "redirect:/user";

    }
///////////////////////////////////////////////////////////////////////////////


}