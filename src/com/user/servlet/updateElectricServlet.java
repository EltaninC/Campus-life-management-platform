package com.user.servlet;

import com.user.entity.Card;
import com.user.service.CardService;
import com.user.service.CardServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class updateElectricServlet extends ThymeleafServlet{
    private CardService cardService=new CardServiceImpl();
    public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int wangluo=Integer.parseInt(req.getParameter("wangluo"));
        HttpSession session=req.getSession();
        Card card= (Card) session.getAttribute("card");
        int card_id=card.getCard_id();
        try {
            cardService.updateElectric(card_id,wangluo);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        processTemplate("wangluo",req,resp);
    }


}
