package com.user.dao;

import com.user.utils.JdbcUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertInfo {
    // 插入请假信息
    public void InsertLeave(Object... args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getConnection();
            // 预编译
            String sql = "insert into `leave`(s_id, Category, Start_Time, End_Time, L_School, LinkManNum, Destination, Reason, Status) value(?,?,?,?,?,?,?,?,?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,args[0]);
            preparedStatement.setObject(2,args[1]);
            preparedStatement.setObject(3,args[2]);
            preparedStatement.setObject(4,args[3]);
            preparedStatement.setObject(5,args[4]);
            preparedStatement.setObject(6,args[5]);
            preparedStatement.setObject(7,args[6]);
            preparedStatement.setObject(8,args[7]);
            preparedStatement.setObject(9,"待审批");
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 关闭连接
        JdbcUtils.CloseResource(connection,preparedStatement);
    }
    // 插入反馈信息
    public void InsertFeed(Object... args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getConnection();
            // 预编译
            String sql = "insert into feedback(`s_id`, `type`, `reason`) value(?,?,?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,args[0]);
            preparedStatement.setObject(2,args[1]);
            preparedStatement.setObject(3,args[2]);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 关闭连接
        JdbcUtils.CloseResource(connection,preparedStatement);
    }
}
