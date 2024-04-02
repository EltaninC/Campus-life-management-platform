package com.user.dao;

import com.user.utils.JdbcUtils;
import com.user.entity.Repairform;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class repairFormDaoImpl implements repairFormDao {
    public ArrayList<Repairform> getAllApply(String s_id) {
        ArrayList<Repairform> arr = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Repairform apm;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "select * from repair where s_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, s_id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                apm = new Repairform();
                apm.setR_id(rs.getInt("r_id"));
                apm.setS_id(rs.getString("s_id"));
                apm.setR_time(rs.getString("r_time"));
                apm.setR_space(rs.getString("r_space"));
                apm.setR_type(rs.getString("r_type"));
                apm.setR_content(rs.getString("r_content"));
                arr.add(apm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            JdbcUtils.CloseResource(connection, preparedStatement);
        }
        return arr;
    }
}

