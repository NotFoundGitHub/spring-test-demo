package com.example.spring.test.demo.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author zhao
 * @version 1.0
 * @date 2020/6/5 17:37
 */

@Data
@ToString
public class LogDto implements Serializable {
    private String methods;
    private String remoteIp;
    private String type;
    private String args;
    private Integer order;
    private Long startTime;
    private Long endTime;
}
