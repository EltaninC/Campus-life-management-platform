package com.user.servlet;

import com.user.entity.Leave;
import com.user.entity.Student;
import com.user.service.RecordService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

// 获取请假记录
public class LeaveRecordServlet extends ThymeleafServlet{
    // 连接Service层
    RecordService recordService = new RecordService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取登录的学生账号
        HttpSession session = request.getSession();
        Student stu = (Student)session.getAttribute("student");
        Object s_id = stu.getS_id();
        // 获取请假表单
        List<Leave> leaves = recordService.leaves(s_id);
        // 将表单保存在session
        session.setAttribute("leaList",leaves);
        // 通过ThymeleafServlet,页面数据填充
        super.processTemplate("TutoringCat/leave_record",request,response);
    }
}
