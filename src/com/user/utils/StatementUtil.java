package com.user.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class StatementUtil {
    // 使用Statement实现对数据表的查询操作
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


