package com.aopLog.demo.aopLogdemo.service;

import com.aopLog.demo.aopLogdemo.dataobject.Operate;
import com.aopLog.demo.aopLogdemo.mapper.OperateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author hzheng
 * @Date 2017/11/8
 */
@Service
public class OperateService {
    @Autowired
    OperateMapper operateMapper;

    public int insert(Operate operate){
        return operateMapper.insert(operate);
    }
}
