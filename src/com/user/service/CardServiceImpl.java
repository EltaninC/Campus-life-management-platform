package com.user.service;

import com.user.dao.CardDaoImpl;
import com.user.entity.Card;

import java.io.IOException;
import java.sql.SQLException;

public class CardServiceImpl implements CardService{
    private CardDaoImpl cardDao=new CardDaoImpl();

    @Override
    public Card findCardById(int s_id) throws SQLException, IOException, ClassNotFoundException {
        return cardDao.findCardById(s_id);
    }

    @Override
    public void updateMoney(int card_id,int money) throws SQLException, IOException, ClassNotFoundException {
        cardDao.updateMoney(card_id,money);
    }

    @Override
    public void updateWater(int card_id,int water) throws SQLException, IOException, ClassNotFoundException {
        cardDao.updateWater(card_id,water);
    }
    @Override
    public void updateElectric(int card_id,int electric) throws SQLException, IOException, ClassNotFoundException {
        cardDao.updateElectric(card_id,electric);
    }
}
