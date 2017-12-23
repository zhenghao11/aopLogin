package com.aopLog.demo.ssodemo.dataobject;

import com.aopLog.demo.ssodemo.annoation.DataLog;
import lombok.Data;

import java.util.Date;

/**
 * @Author hzheng
 * @Date 2017/11/8
 */
@Data
@DataLog(name = "用户信息")
public class User {

    private Integer id;

    @DataLog(name = "用户名")
    private String userName;
    @DataLog(name = "密码")
    private String password;

    private Date lastOutTime;


}
