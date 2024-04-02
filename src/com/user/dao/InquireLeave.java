package com.user.dao;


import com.user.entity.Leave;

import java.util.List;

import static com.user.utils.StatementUtil.get;

// 获取请假记录---学生；
public class InquireLeave {
    public List<Leave> getLeaves(Object... s_id){
        // 通过学号查询
        String sql = "select * from `leave` where s_id = ?;";
        // 通过StatementUtil获取数据库数据并制成表单
        List<Leave> leaves = get(sql, Leave.class, s_id);
        return leaves;
    }
}
