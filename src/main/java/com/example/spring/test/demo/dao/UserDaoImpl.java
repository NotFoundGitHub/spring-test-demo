package com.example.spring.test.demo.dao;

import com.example.spring.test.demo.dao.daoImpl.UserDao;
import com.example.spring.test.demo.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.Random;

/**
 * @author zhao
 * @version 1.0
 * @date 2020/6/5 15:05
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public UserDto getUserDtoById(Long id) {
        if(id < 10){
            return UserDto.builder().id(id).name("test"+id).build();
        }
        return null;
    }
}
