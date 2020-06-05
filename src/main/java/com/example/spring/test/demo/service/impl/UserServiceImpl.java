package com.example.spring.test.demo.service.impl;

import com.example.spring.test.demo.dao.daoImpl.UserDao;
import com.example.spring.test.demo.dto.UserDto;
import com.example.spring.test.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhao
 * @version 1.0
 * @date 2020/6/5 15:04
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDto getUserById(Long id) {
        return userDao.getUserDtoById(id);
    }
}
