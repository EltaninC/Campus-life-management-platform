package com.user.dao;


import com.user.entity.Course;
import com.user.entity.FeedBack;
import com.user.entity.Leave;

import java.util.List;

import static com.user.utils.StatementUtil.get;

public class tInquireInfo {
    public List<Leave> getLeaves(Object... s_id){
        // 查询全部请假信息
        String sql = "select * from `leave` ORDER BY Start_Time DESC";
        // 通过StatementUtil获取数据库数据并制成表单
        List<Leave> leaves = get(sql, Leave.class);
        return leaves;
    }

    public List<Course> getCourse(Object... args){
        // 查询全部请假信息
        String sql = "select * from `course` where t_id=?";
        // 通过StatementUtil获取数据库数据并制成表单
        List<Course> course = get(sql, Course.class, args);
        return course;
    }

    public List<FeedBack> getFeeds(){
        String sql = "select * from `feedback`";
        // 通过StatementUtil获取数据库数据并制成表单
        List<FeedBack> feedBacks = get(sql, FeedBack.class);
        return feedBacks;
    }
}
