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
import java.util.ArrayList;

public class repairFormServlet extends ThymeleafServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
            Student stu = (Student) session.getAttribute("student");
            int id = stu.getS_id();
            String s_id = String.valueOf(id);

            addService adsc1 = new addServiceImpl();
            ArrayList<Repairform> arr = adsc1.getAllApply(s_id);
            session.setAttribute("arr",arr);
            processTemplate("repairForm",req,resp);

        }

    }

