package com.aopLog.demo.aopLogdemo.dataobject;

import lombok.Data;

/**
 * 进度条
 * @Author hzheng
 * @Date 2017/11/9
 */
@Data
public class Progress {
    private Long pBytesRead;

    private Long pContentLength;

    private Long pItems;

}
