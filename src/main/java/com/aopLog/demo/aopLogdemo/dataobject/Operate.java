package com.aopLog.demo.aopLogdemo.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * 日志实体
 *
 * @Author hzheng
 * @Date 2017/11/8
 */
@Data
public class Operate {

    private Integer id;

    private String action;

    private String operator;

    private Date createTime;

}
