package com.user.servlet;

import com.user.entity.Student;
import com.user.service.InsertInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LeaveServlet extends HttpServlet {
    // 提交请假信息
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符编码方式
        request.setCharacterEncoding("utf-8");
        // 获取提交的信息
        HttpSession session = request.getSession();
        Student stu = (Student)session.getAttribute("student");
        Object s_id = stu.getS_id();
        Object Category = request.getParameter("Category");
        Object StartTime = request.getParameter("StartTime");
        Object EndTime = request.getParameter("EndTime");
        Object LeaveSchool = request.getParameter("LeaveSchool");
        Object LinkMan = request.getParameter("LinkMan");
        String Province = request.getParameter("Province");
        String City = request.getParameter("City");
        String Destination = Province + City;
        Object LeaveCause =request.getParameter("LeaveCause");

        // 连接Service
        InsertInfoService insertInfoService = new InsertInfoService();
        insertInfoService.InsertLeave(s_id,Category,StartTime,EndTime,LeaveSchool,LinkMan,Destination,LeaveCause);
        // 返回辅导猫界面
        request.getRequestDispatcher("leave.html").forward(request,response);
    }
}
