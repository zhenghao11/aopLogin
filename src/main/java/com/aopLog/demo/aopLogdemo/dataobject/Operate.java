package com.aopLog.demo.aopLogdemo.dataobject;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志实体
 *
 * @Author hzheng
 * @Date 2017/11/8
 */
@Data
public class Operate implements Serializable {

    private static final long serialVersionUID = 5112780457785364268L;

    private Integer id;

    private String action;

    private String operator;

    private Date createTime;

}
