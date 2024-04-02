package com.user.servlet;

import com.user.entity.Card;
import com.user.service.CardService;
import com.user.service.CardServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class updateWaterServlet extends ThymeleafServlet{
    private CardService cardService=new CardServiceImpl();
    public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int shuidian=Integer.parseInt(req.getParameter("shuidian"));
        HttpSession session=req.getSession();
        Card card= (Card) session.getAttribute("card");
        int card_id=card.getCard_id();
        try {
            cardService.updateWater(card_id,shuidian);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        processTemplate("shuidian",req,resp);
    }

}
