package com.example.spring.test.demo.dao.daoImpl;

import com.example.spring.test.demo.dto.UserDto;

/**
 * @author zhao
 * @version 1.0
 * @date 2020/6/5 15:05
 */
public interface UserDao {
    UserDto getUserDtoById(Long id);
}
