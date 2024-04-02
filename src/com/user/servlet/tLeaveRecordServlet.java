package com.user.servlet;

import com.user.entity.Leave;
import com.user.service.getInfoService;
import com.user.servlet.ThymeleafServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

// 获取请假表单
public class tLeaveRecordServlet extends ThymeleafServlet {
    // 连接Service层
    com.user.service.getInfoService getInfoService = new getInfoService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取Session
        HttpSession session = request.getSession();
        // 获取请假表单
        List<Leave> leaves = getInfoService.leaves();
        // 将表单保存在session
        session.setAttribute("leaList",leaves);
        // 通过ThymeleafServlet,页面数据填充
        super.processTemplate("permit_leave",request,response);
    }
}
