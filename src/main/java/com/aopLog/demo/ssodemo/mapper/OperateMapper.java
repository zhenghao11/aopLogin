package com.aopLog.demo.ssodemo.mapper;

import com.aopLog.demo.ssodemo.dataobject.Operate;
import java.util.List;

public interface OperateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Operate record);

    Operate selectByPrimaryKey(Integer id);

    List<Operate> selectAll();

    int updateByPrimaryKey(Operate record);
}