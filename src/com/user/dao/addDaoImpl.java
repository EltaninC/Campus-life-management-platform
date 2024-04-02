package com.user.dao;

import com.user.utils.JdbcUtils;
import com.user.entity.Repairform;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class addDaoImpl implements addDao{
    @Override
    public void addDao(Repairform a) {
        String s_id = a.getS_id();
        String time = a.getR_time();
        String space = a.getR_space();
        String type = a.getR_type();
        String reason = a.getR_content();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = JdbcUtils.getConnection();
            String sql = "insert into repair (s_id,r_time,r_space,r_type,r_content) values(?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setInt(1,1);
            preparedStatement.setString(1,s_id);
            preparedStatement.setString(2,time);
            preparedStatement.setString(3,space);
            preparedStatement.setString(4,type);
            preparedStatement.setString(5,reason);
            preparedStatement.execute();
        }catch (IOException | ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }finally {
            JdbcUtils.CloseResource(connection,preparedStatement);
        }

    }
}
