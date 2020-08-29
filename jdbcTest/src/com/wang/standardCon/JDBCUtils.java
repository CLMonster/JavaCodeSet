package com.wang.standardCon;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author WangDebao
 * @create 2020-08-28 10:07
 */
public class JDBCUtils {

    /**
     * 获取数据库连接
     * @return 返回一个Connection对象
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        //1.读取配置文件
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties"); // 相对路径
        Properties pros = new Properties();
        pros.load(is);
        // 获取四个基本信息：数据库地址，用户名、密码、驱动
        String user = pros.getProperty("user");
        String url = pros.getProperty("url");
        String password = pros.getProperty("password");
        String driverClass = pros.getProperty("driverClass");

        // 2.加载驱动
        Class.forName(driverClass);

        // 3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);

        // 4.返回数据库对象
        return conn;
    }


    /**
     * 关闭Connection，PreparedStatement，适用于增删改
     * @param conn
     * @param ps
     */
    public static void closeResource(Connection conn,PreparedStatement ps){

        try {
            if(conn != null){
                conn.close();

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (ps != null)   {
                ps.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * 关闭Connection，PreparedStatement，ResultSet资源，适用于查询
     * @param conn
     * @param ps
     * @param rs
     */
    public static void closeResource(Connection conn, PreparedStatement ps, ResultSet rs){

        try {
            if(conn != null){
                conn.close();

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (ps != null)   {
                ps.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            if (rs != null)   {
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * 实现对数据库的增删改操作
     * @param sql 要执行的sql语句
     * @param args 要填充的占位符
     */
    public static void update(String sql,Object ...args) {

        Connection conn = null;
        PreparedStatement ps =null;
        try {
            // 1.获取连接
            conn = JDBCUtils.getConnection();
            // 2.获取PreparedStatement的实例 (或：预编译sql语句)
            ps = conn.prepareStatement(sql);
            // 3.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);  //parameterIndex(占位符)下标从1开始
            }
            // 4.执行sql语句
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 5.关闭数据库连接资源
            JDBCUtils.closeResource(conn, ps);
        }
    }



}

