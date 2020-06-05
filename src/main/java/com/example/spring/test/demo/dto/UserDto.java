package com.example.spring.test.demo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zhao
 * @version 1.0
 * @date 2020/6/5 14:56
 */
@Data
@ToString
@Builder
public class UserDto implements Serializable {

    private static final long serialVersionUID = -5293802335284097466L;
    private Long id;
    private String name;
    private String phone;
    private Integer age;
}
