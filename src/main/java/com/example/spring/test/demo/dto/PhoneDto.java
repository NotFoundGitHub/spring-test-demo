package com.example.spring.test.demo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author zhao
 * @version 1.0
 * @date 2020/6/8 9:54
 */
@Data
@ToString
@Builder
public class PhoneDto {
    private Integer prefix;
    private String phone;
    private String province;
}
