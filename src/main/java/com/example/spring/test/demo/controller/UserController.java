package com.example.spring.test.demo.controller;

import com.example.spring.test.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhao
 * @version 1.0
 * @date 2020/6/5 14:51
 */
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public String getUser(@RequestParam Long id){
        log.info("id:{}",id);
        return userService.getUserById(id).toString();
    }
}
