package com.user.servlet;

import com.user.entity.FeedBack;
import com.user.service.getInfoService;
import com.user.servlet.ThymeleafServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class tFeedRecordServlet extends ThymeleafServlet {
    // 连接Service层
    com.user.service.getInfoService getInfoService = new getInfoService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        // 获取反馈表单
        List<FeedBack> feedBacks = getInfoService.feedBacks();
        // 将表单保存在session
        session.setAttribute("feeList",feedBacks);
        // 通过ThymeleafServlet,页面数据填充
        super.processTemplate("tfeed_record",request,response);
    }
}
