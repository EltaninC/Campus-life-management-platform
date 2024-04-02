package com.user.servlet;

import com.user.entity.Course;
import com.user.entity.Teacher;
import com.user.service.getInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CourseServlet extends HttpServlet {
    com.user.service.getInfoService getInfoService = new getInfoService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 获取Session
        HttpSession session = request.getSession();
        // 获取课程表单
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        List<Course> courses = getInfoService.courses(teacher.t_id);
        // 将表单保存在session
        session.setAttribute("couList",courses);
        // 通过ThymeleafServlet,页面数据填充
        request.getRequestDispatcher("t_schedule.jsp").forward(request,response);
    }
}
