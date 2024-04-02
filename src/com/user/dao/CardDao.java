package com.user.dao;

import com.user.entity.Card;

import java.io.IOException;
import java.sql.SQLException;

public interface CardDao {
    public Card findCardById(int s_id) throws SQLException, IOException, ClassNotFoundException;
    public void updateMoney(int card_id,int money) throws SQLException, IOException, ClassNotFoundException;
    public void updateWater(int card_id,int water) throws SQLException, IOException, ClassNotFoundException;
    public void updateElectric(int card_id,int electric) throws SQLException, IOException, ClassNotFoundException;
}
