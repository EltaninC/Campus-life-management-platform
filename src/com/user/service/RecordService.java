package com.user.service;

import com.user.dao.InquireFeed;
import com.user.dao.InquireLeave;
import com.user.entity.FeedBack;
import com.user.entity.Leave;

import java.util.List;

// 获取记录---辅导猫；
public class RecordService {
    // 连接Dao层
    InquireLeave inquireLeave = new InquireLeave();
    InquireFeed inquireFeed = new InquireFeed();
    // 获取请假记录
    public List<Leave> leaves(Object... s_id){
        return inquireLeave.getLeaves(s_id);
    }
    // 获取反馈记录
    public List<FeedBack> feedBacks(Object... s_id){ return inquireFeed.getFeeds(s_id); }
}

