package com.user.service;


import com.user.dao.OperateLeave;

public class OperateLeaveService {
    // 连接Dao层
    com.user.dao.OperateLeave operateLeave = new OperateLeave();
    //
    public void OperateLeave(Object... args){
        if(!args[0].equals("删除")){
            operateLeave.SetLeave(args);
        }else{
            operateLeave.DeleteLeave(args);
        }
    }
}
