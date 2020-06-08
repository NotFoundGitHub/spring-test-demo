package com.example.spring.test.demo.service.impl;

import com.example.spring.test.demo.dto.PhoneDto;
import com.example.spring.test.demo.service.PhoneService;
import org.springframework.stereotype.Service;

/**
 * @author zhao
 * @version 1.0
 * @date 2020/6/8 9:56
 */
@Service("phoneService")
public class PhoneServiceImpl implements PhoneService {
    @Override
    public PhoneDto getPhoneInfoByPhoneNumber(String phone,Integer prefix) {
        return PhoneDto.builder().phone(phone).prefix(86).province("shannxi").build();
    }
}
