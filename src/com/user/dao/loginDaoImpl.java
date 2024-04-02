package com.user.dao;

import com.user.entity.Teacher;
import com.user.utils.JdbcUtils;
import com.user.entity.Student;
import com.user.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDaoImpl implements loginDao {
    @Override
    public Student loginDao(User u) {
        String account = u.getAccount();
        String password = u.getPassword();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;

        ResultSet rest = null;
        ResultSet rest1 = null;

        try {
            connection = JdbcUtils.getConnection();
            String sql = "select * from user_info where account=? and password=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, password);
            rest = preparedStatement.executeQuery();
            User user = new User();
            Student stu = new Student();
            while (rest.next()) {
                user.setAccount(rest.getString("account"));
                user.setPassword(rest.getString("password"));
                user.setSort(rest.getString("sort"));
                user.setU_id(rest.getInt("u_id"));
            }

            String a1 = user.getAccount();
            int uid = Integer.parseInt(a1, 10);
            String sql1 = "select * from student where s_id=" + uid;
            preparedStatement1 = connection.prepareStatement(sql1);
            rest1 = preparedStatement1.executeQuery();
            while (rest1.next()) {
                stu.setS_id(rest1.getInt("s_id"));
                stu.setSort(rest1.getString("sort"));
                stu.setS_name(rest1.getString("s_name"));
                stu.setClass_(rest1.getString("class"));
                stu.setCollege(rest1.getString("college"));
                stu.setGender(rest1.getString("gender"));
                return stu;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rest != null) {
                try {
                    rest.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rest1 != null) {
                try {
                    rest1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        JdbcUtils.CloseResource(connection, preparedStatement);
        JdbcUtils.CloseResource(connection, preparedStatement1);
        return null;
    }

    @Override
    public Teacher loginDao1(User u) {

        String account = u.getAccount();
        String password = u.getPassword();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement2 = null;
        ResultSet rest = null;
        ResultSet rest2 = null;

        try {
            connection = JdbcUtils.getConnection();
            String sql = "select * from user_info where account=? and password=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, password);
            rest = preparedStatement.executeQuery();
            User user = new User();
            Teacher teac = new Teacher();
            while (rest.next()) {
                user.setAccount(rest.getString("account"));
                user.setPassword(rest.getString("password"));
                user.setSort(rest.getString("sort"));
                user.setU_id(rest.getInt("u_id"));
            }

            String a1 = user.getAccount();
            int uid = Integer.parseInt(a1, 10);
            String sql2 = "select * from teacher where t_id=" + uid;
            preparedStatement2 = connection.prepareStatement(sql2);
            rest2 = preparedStatement2.executeQuery();
            while (rest2.next()) {
                teac.setT_id(rest2.getInt("t_id"));
                teac.setSort(rest2.getString("sort"));
                teac.setT_name(rest2.getString("t_name"));
                teac.setJob(rest2.getString("job"));
                teac.setClass_(rest2.getString("class"));
                teac.setCollege(rest2.getString("college"));
                teac.setGender(rest2.getString("gender"));
                return teac;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rest != null) {
                try {
                    rest.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rest2 != null) {
                try {
                    rest2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        JdbcUtils.CloseResource(connection, preparedStatement);
        JdbcUtils.CloseResource(connection, preparedStatement2);
        return null;

    }
}
