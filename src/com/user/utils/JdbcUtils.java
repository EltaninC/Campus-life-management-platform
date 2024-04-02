package com.user.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JdbcUtils {
    public static Connection getConnection () throws IOException, ClassNotFoundException, SQLException {
        // 获取信息
        InputStream resource = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(resource);
        String user = properties.getProperty("username");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driverClassName");
        // 加载驱动
        Class.forName(driver);
        resource.close();
        // 获取连接
        return DriverManager.getConnection(url, user, password);
    }


    public static void CloseResource(Connection connection, Statement statement) {
        if(connection!=null ){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        try {

            if(statement !=null) {
                statement.close();
            }
        } catch ( SQLException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> get(String sql, Class<T> clazz, Object... args) {
        ArrayList<T> list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            // 获取结果集
            resultSet = preparedStatement.executeQuery();

            // 获取结果集的元数据
            ResultSetMetaData rsmd = resultSet.getMetaData();

            // 获取结果集的列数
            int columnCount = rsmd.getColumnCount();

            while (resultSet.next()) {

                T t  = clazz.newInstance();

                for (int i = 0; i < columnCount; i++) {
                    // //1. 获取列的名称
                    // String columnName = rsmd.getColumnName(i+1);

                    // 1. 获取列的别名
                    String columnName = rsmd.getColumnLabel(i + 1);

                    // 2. 根据列名获取对应数据表中的数据
                    Object columnVal = resultSet.getObject(columnName);

                    // 3. 将数据表中得到的数据，封装进对象
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, columnVal);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.CloseResource(connection,preparedStatement);
        }

        return list;
    }
}


