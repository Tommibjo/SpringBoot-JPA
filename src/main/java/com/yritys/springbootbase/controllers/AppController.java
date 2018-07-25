/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yritys.springbootbase.controllers;

import com.yritys.springbootbase.jpa.User;
import com.yritys.springbootbase.jpa.UserRepository;
import com.yritys.springbootbase.services.AppServices;
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
    private AppServices appservices;

    @RequestMapping("/")
    public String home(Model model) {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String getForm(@RequestParam String name, @RequestParam String surname, @RequestParam int age, @RequestParam String gender) {
        appservices.addUser(name, surname, age, gender);
        return "redirect:/";
    }

    @RequestMapping("/users")
    public String users(Model model) {
        model.addAttribute("userList", appservices.getAllUsers());
        return "users";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(@RequestParam Long id, Model model) {
        model.addAttribute("user", appservices.getUser(id));
        return "user";
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String remove(@RequestParam Long id){
        appservices.deleteUser(id);
        return "redirect:/users";
    }
}
