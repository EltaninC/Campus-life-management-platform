package com.user.servlet;

import com.user.entity.Repairform;
import com.user.entity.Student;
import com.user.service.addService;
import com.user.service.addServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class addServlet extends ThymeleafServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String time = req.getParameter("r_time");
        String space = req.getParameter("r_space");
        String type = req.getParameter("r_type");
        String reason = req.getParameter("r_content");
        Repairform a = new Repairform();

        if(time==null){
            processTemplate("repair",req,resp);
        }else {
            HttpSession session = req.getSession();

            System.out.println(session.getAttribute("student").toString());
            Student stu = (Student) session.getAttribute("student");
            int id = stu.getS_id();
            String s_id = String.valueOf(id);
            a.setS_id(s_id);
            a.setR_time(time);
            a.setR_space(space);
            a.setR_type(type);
            a.setR_content(reason);
            addService adsc = new addServiceImpl();
            adsc.addService(a);
            processTemplate("repair",req,resp);
        }


    }
}
