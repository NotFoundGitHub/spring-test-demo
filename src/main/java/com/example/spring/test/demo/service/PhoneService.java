package com.example.spring.test.demo.service;

import com.example.spring.test.demo.dto.PhoneDto;

/**
 * @author zhao
 * @version 1.0
 * @date 2020/6/8 9:53
 */
public interface PhoneService {
    PhoneDto getPhoneInfoByPhoneNumber(String phone,Integer prefix);
}
