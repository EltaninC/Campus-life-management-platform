package com.user.dao;

import com.user.entity.Card;
import com.user.utils.JdbcUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CardDaoImpl extends Card implements CardDao{

    public Card findCardById(int s_id) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs ;
        Card card=new Card();

        String sql = "select * from card where s_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, s_id);
            rs = ps.executeQuery();
            if(rs.next()) {
                //封装对象
                card= new Card();
                card.setS_id(s_id);
                card.setCard_id(rs.getInt("card_id"));
                card.setMoney(rs.getInt("money"));
                card.setWater(rs.getInt("water"));
                card.setElectric(rs.getInt("electric"));
            }
            String sql2="select * from student where s_id=?";
            ps=conn.prepareStatement(sql2);
            ps.setInt(1,rs.getInt("s_id"));
            rs=ps.executeQuery();
            if(rs.next()){
                card.setS_name(rs.getString("s_name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }JdbcUtils.CloseResource(conn,ps);
        return card;
    }

    @Override
    public void updateMoney(int card_id,int money) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement ps = null;
        String sql="update card set money=money+? where card_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, money);
            ps.setInt(2, card_id);
            int a = ps.executeUpdate();
            if (a > 0) System.out.println("修改成功");
            else System.out.println("修改失败");
        }catch (Exception e) {
            e.printStackTrace();
        }JdbcUtils.CloseResource(conn,ps);
    }

    @Override
    public void updateWater(int card_id,int water) throws SQLException, IOException, ClassNotFoundException {
        Connection conn=JdbcUtils.getConnection();
        PreparedStatement ps=null;
        String sql="update card set water=water+? where card_id=?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,water);
            ps.setInt(2,card_id);
            int a = ps.executeUpdate();
            if (a > 0) System.out.println("修改成功");
            else System.out.println("修改失败");
        }catch (Exception e) {
            e.printStackTrace();
        }JdbcUtils.CloseResource(conn,ps);

    }

    @Override
    public void updateElectric(int card_id,int electric) throws SQLException, IOException, ClassNotFoundException {
        Connection conn=JdbcUtils.getConnection();
        PreparedStatement ps=null;
        String sql="update card set electric=electric+? where card_id=?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,electric);
            ps.setInt(2,card_id);
        }catch (Exception e) {
            e.printStackTrace();
        }JdbcUtils.CloseResource(conn,ps);
    }


}