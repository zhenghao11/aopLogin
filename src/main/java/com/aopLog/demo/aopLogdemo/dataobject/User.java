package com.aopLog.demo.aopLogdemo.dataobject;

import com.aopLog.demo.aopLogdemo.annoation.DataLog;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author hzheng
 * @Date 2017/11/8
 */
@Data
@DataLog(name = "用户信息")
public class User implements Serializable {

    private static final long serialVersionUID = 6975117390327965354L;

    private Integer id;

    @DataLog(name = "用户名")
    private String userName;
    @DataLog(name = "密码")
    private String password;

    private Date lastOutTime;


}
