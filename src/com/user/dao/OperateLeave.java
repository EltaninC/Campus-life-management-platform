package com.user.dao;

import com.user.utils.JdbcUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OperateLeave {
    public void DeleteLeave(Object... args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getConnection();
            // 预编译
            String sql = "delete from `leave` where s_id=? and Start_Time=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,args[1]);
            preparedStatement.setObject(2,args[2]);
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
    public void SetLeave(Object... args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getConnection();
            // 预编译
            String sql = "update `leave` set Status=? where s_id=? and Start_Time=?";
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
