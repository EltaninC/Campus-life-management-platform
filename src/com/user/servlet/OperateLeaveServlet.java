package com.user.servlet;

import com.user.entity.Leave;
import com.user.service.OperateLeaveService;
import com.user.service.getInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class OperateLeaveServlet extends ThymeleafServlet {
    // 连接Service层
    com.user.service.getInfoService getInfoService = new getInfoService();
    OperateLeaveService operateLeaveService = new OperateLeaveService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符编码方式
        request.setCharacterEncoding("utf-8");
        // 获取提交的信息
        HttpSession session = request.getSession();
        Object s_id = request.getParameter("s_id");
        Object Star_Time = request.getParameter("Start_Time");
        String function = request.getParameter("function");
        //操作信息
        operateLeaveService.OperateLeave(function,s_id,Star_Time);
        // 返回leave界面
        // 获取请假表单
        List<Leave> leaves = getInfoService.leaves();
        // 将表单保存在session
        session.setAttribute("leaList",leaves);
        // 通过ThymeleafServlet,页面数据填充
        super.processTemplate("permit_leave",request,response);
    }
}
