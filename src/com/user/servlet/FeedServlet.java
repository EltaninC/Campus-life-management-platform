package com.user.servlet;

import com.user.entity.Student;
import com.user.service.InsertInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class FeedServlet extends HttpServlet {
    // 提交反馈信息
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符编码方式
        request.setCharacterEncoding("utf-8");
        // 获取提交的信息
        HttpSession session = request.getSession();
        Student stu = (Student)session.getAttribute("student");
        Object s_id = stu.getS_id();
        Object type = request.getParameter("type");
        Object problem = request.getParameter("problem");
        // 建立连接Service
        InsertInfoService insertInfoService = new InsertInfoService();
        insertInfoService.InsertFeed(s_id,type,problem);
        // 返回辅导猫界面
        request.getRequestDispatcher("feedback.html").forward(request,response);
    }
}
