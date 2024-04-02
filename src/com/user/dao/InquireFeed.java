package com.user.dao;


import com.user.entity.FeedBack;

import java.util.List;

import static com.user.utils.StatementUtil.get;

public class InquireFeed {
    public List<FeedBack> getFeeds(Object... s_id){
        // 通过学号查询
        String sql = "select * from `feedback` where s_id = ?;";
        // 通过StatementUtil获取数据库数据并制成表单
        List<FeedBack> feedBacks = get(sql, FeedBack.class, s_id);
        return feedBacks;
    }
}
