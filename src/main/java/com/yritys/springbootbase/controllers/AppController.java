/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yritys.springbootbase.controllers;

import com.yritys.springbootbase.jpa.User;
import com.yritys.springbootbase.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Tommi
 */
@Controller
public class AppController {

    @Autowired
    private UserRepository userrepository;

    @RequestMapping("/")
    public String home(Model model) {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String getForm(@RequestParam String name, @RequestParam String surname, @RequestParam int age, @RequestParam String gender) {
        userrepository.saveAndFlush(new User(name, surname, gender, age));
        return "redirect:/";
    }

    @RequestMapping("/users")
    public String users(Model model) {
        model.addAttribute("userList", userrepository.findAll());
        
        return "users";
    }
    
    @RequestMapping("/user")
    public String user(@RequestParam String user, Model model){
        model.addAttribute("user", user);
        return "users";
    }

}
