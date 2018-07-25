/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yritys.springbootbase.services;

import com.yritys.springbootbase.jpa.User;
import com.yritys.springbootbase.jpa.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * Service layer between JPA & front
 */
@Component
public class AppServices {

    @Autowired
    private UserRepository userrepository;

    public void addUser(String name, String surname, int age, String gender) {
        userrepository.saveAndFlush(new User(name, surname, gender, age));
    }

    public List getAllUsers() {
        return userrepository.findAll();
    }

    public User getUser(Long id) {
        return userrepository.findOne(id);
    }
    
    public void deleteUser(Long id) {
        userrepository.delete(id);
    }
}
