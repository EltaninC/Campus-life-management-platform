package com.user.servlet;

import com.user.entity.Card;
import com.user.entity.Student;
import com.user.service.CardService;
import com.user.service.CardServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


public class findCardByIdServlet extends ThymeleafServlet{
    private CardService cardService=new CardServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession session=req.getSession();
        Student stu = (Student) session.getAttribute("student");
        int s_id = stu.getS_id();
        Card card=new Card();
        try {
            card=cardService.findCardById(s_id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        session.setAttribute("card",card);

        String viewName="card";
        processTemplate("search",req,resp);
    }
}
