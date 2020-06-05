package com.example.spring.test.demo.service;

import com.example.spring.test.demo.dto.UserDto;

/**
 * @author zhao
 * @version 1.0
 * @date 2020/6/5 14:52
 */
public interface UserService {
    UserDto getUserById(Long id);
}
