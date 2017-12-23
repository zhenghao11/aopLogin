package com.aopLog.demo.aopLogdemo.serviceTest;

import com.aopLog.demo.aopLogdemo.dataobject.User;
import com.aopLog.demo.aopLogdemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author hzheng
 * @Date 2017/12/23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserService userService;

    @Test
    public void testAdd(){
        User user = new User();
        user.setUserName("testAop");
        user.setPassword("123456");
        userService.addUser(user);
    }
}
