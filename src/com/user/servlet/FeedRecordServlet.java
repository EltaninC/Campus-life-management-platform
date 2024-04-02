package com.user.servlet;

import com.user.entity.FeedBack;
import com.user.entity.Student;
import com.user.service.RecordService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class FeedRecordServlet extends ThymeleafServlet{
    // 连接Service层
    RecordService recordService = new RecordService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取登录的学生账号
        HttpSession session = request.getSession();
        Student stu = (Student)session.getAttribute("student");
        Object s_id = stu.getS_id();

        // 获取反馈表单
        List<FeedBack> feedBacks = recordService.feedBacks(s_id);
        // 将表单保存在session
        session.setAttribute("feeList",feedBacks);
        // 通过ThymeleafServlet,页面数据填充
        super.processTemplate("feed_record",request,response);
    }
}
