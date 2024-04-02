package com.user.service;


import com.user.dao.tInquireInfo;
import com.user.entity.Course;
import com.user.entity.FeedBack;
import com.user.entity.Leave;

import java.util.List;

public class getInfoService {
    // 连接Dao层
    com.user.dao.tInquireInfo tInquireInfo = new tInquireInfo();
    // 获取请假记录
    public List<Leave> leaves(){ return tInquireInfo.getLeaves(); }
    // 获取课程信息
    public List<Course> courses(Object... args){ return tInquireInfo.getCourse(args); }
    // 获取反馈记录
    public List<FeedBack> feedBacks(){ return tInquireInfo.getFeeds(); }
}
