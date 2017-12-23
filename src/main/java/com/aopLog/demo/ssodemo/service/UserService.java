package com.aopLog.demo.ssodemo.service;

import com.aopLog.demo.ssodemo.dataobject.User;
import com.aopLog.demo.ssodemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author hzheng
 * @Date 2017/11/8
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public int addUser(User user){
        return userMapper.insert(user);
    }

    public int deleteByPrimaryKey(User user) {
        return userMapper.deleteByPrimaryKey(user.getId());
    }

    public int update(User user){
        return userMapper.updateByPrimaryKey(user);
    }

    public User selectByPrimaryKey(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

}
