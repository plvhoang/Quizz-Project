package com.example.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class UserController {
	@RequestMapping(value={"/"},method = RequestMethod.GET )
    public String viewLogin(Model model){
        return "index";
    }
}
