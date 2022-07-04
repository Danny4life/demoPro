package com.example.demopro.controller;

import com.example.demopro.model.UsersModel;
import com.example.demopro.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    //write a method to redirect user to a specific thymeleaf page
    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new UsersModel());
        return "register_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new UsersModel());
        return "login_page";
    }

    //Controller to handle incoming requests and log in
    @PostMapping("/register")
    public String register(@ModelAttribute UsersModel usersModel){
        UsersModel registeredUser = usersService.registerUser(usersModel.getLogin(), usersModel.getPassword(), usersModel.getEmail());
        if (registeredUser == null){
            return "error_page";
        }
        else{
            return "redirect:/login";
        }
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UsersModel usersModel, Model model){
        UsersModel authenticated = usersService.authentication(usersModel.getLogin(), usersModel.getPassword());
        if (authenticated != null){
            model.addAttribute("userLogin", authenticated.getLogin());
            if((authenticated.getLogin().equals("admin123")) && (authenticated.getPassword().equals("SCHool1234!#"))){
                return  "redirect:/product";
            }else{
                return "redirect:/customerpage";
            }

        }
        else{
            return "register_page";
        }
    }
}
