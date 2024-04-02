package com.user.servlet;

import com.user.entity.Student;
import com.user.entity.Teacher;
import com.user.entity.User;
import com.user.service.loginService;
import com.user.service.loginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class loginServlet extends ThymeleafServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String sort = req.getParameter("sort");
        HttpSession session = req.getSession();
        User u = new User();
        u.setAccount(account);
        u.setPassword(password);
        loginService l = new loginServiceImpl();

        //实现登录服务层的业务逻辑层
        if(sort.equals("s")){
            Student student = l.loginService(u);
            if(student!=null){
                session.setAttribute("student",student);
                processTemplate("middle",req,resp);
            }else{
                req.getRequestDispatcher("/loginFail.html").forward(req,resp);
            }

        }
        if(sort.equals("t")){
            Teacher teacher = l.loginService1(u);
            if(teacher!=null){
                session.setAttribute("teacher",teacher);
                processTemplate("teacher_port",req,resp);
            }else{
                req.getRequestDispatcher("/loginFail.html").forward(req,resp);
            }
        }

    }
}
