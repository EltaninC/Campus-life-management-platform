package com.user.service;


import com.user.dao.InsertInfo;

public class InsertInfoService {
    // 连接Dao层
    InsertInfo insertInfo = new InsertInfo();
    // 插入请假信息
    public void InsertLeave(Object... args){
        insertInfo.InsertLeave(args);
    }
    // 插入反馈信息
    public void InsertFeed(Object... args){
        insertInfo.InsertFeed(args);
    }
}
