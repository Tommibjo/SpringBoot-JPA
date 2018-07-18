/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yritys.springbootbase.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Tommi
 */ 
@Controller
public class AppController {
    
    @RequestMapping("/")
    public String home(){
        return "index";
    }
}
