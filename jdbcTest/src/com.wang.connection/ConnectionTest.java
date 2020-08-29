package com.wang.connection;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// 这是一个公共类
public class ConnectionTest {

    /**
     * 方式1
     * @throws SQLException
     */
    @Test
    public void connectionTest01() throws SQLException {
        // 获取Driver实现类对象
        Driver driver = new com.mysql.jdbc.Driver();
        // jdbc:mysql :协议
        // localhost: ip地址
        // 3306 :mysql端口号
        // test ：数据库名
        String url = "jdbc:mysql://10.211.55.3:3306/test";
        // 将用户名和密码封装在Properties中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        Connection conn = driver.connect(url, info);
        // 如果打印成功，说明连接成功
        System.out.println(conn);
    }


    /**
     * 方式2：使用反射
     * @throws Exception
     */
    @Test
    public void connectionTest02() throws Exception{
        // 1.获取Driver实现类对象:使用反射
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver con = (Driver) clazz.newInstance();

        // 2.mysql的地址，用户名和密码
        String url = "jdbc:mysql://10.211.55.3:3306/test";
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","root");

        Connection connect = con.connect(url, info);
        System.out.println(connect);

    }

    /**
     * 创建数据库连接的第三中方式
     * 使用DriverManager实现数据库的连接。体会获取连接必要的4个基本要素。
     */
    @Test
    public void connectiontest03() throws Exception {
        // 1.数据库连接四要素
        String url = "jdbc:mysql://localhost:3307/test?autoReconnect=true&useSSL=false";
        String username = "root";
        String password = "root";
        String driverName = "com.mysql.jdbc.Driver";

        // 2.实例化Driver
        Class clazz = Class.forName(driverName);
        Driver o = (Driver) clazz.newInstance();

        // 3.注册驱动
        DriverManager.registerDriver(o);

        // 获取连接
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println(connection);

    }


    /**
     * 方式4
     * @throws Exception
     */
    @Test
    public void connectionTest04() throws Exception{
        // 1.数据库连接四要素
        String url = "jdbc:mysql://localhost:3307/test?useSSL=false";
        String username = "root";
        String password = "root";
        String driverName = "com.mysql.jdbc.Driver";

        // 将Driver类加载到内存中
        Class.forName(driverName);

        // 2.实例化Driver
//        Class clazz = Class.forName(driverName);
//        Driver o = (Driver) clazz.newInstance();
        // 3.注册驱动
//        DriverManager.registerDriver(o);
        //以上代码被注释的原因:在Driver.class中有如下代码，
        // 在类加载的时候静态代码块被执行
        /**
         * static {
         *                 try {
         *                     DriverManager.registerDriver(new Driver());
         *                 } catch (SQLException var1) {
         *                     throw new RuntimeException("Can't register driver!");
         *                 }
         *             }
         */

        // 获取连接
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println(connection);

    }

    /**
     * 方式5
     * @throws Exception
     */
    @Test
    public void connectionTest05() throws Exception {
        // 1.加载配置文件
        InputStream ras = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties props = new Properties();
        props.load(ras);

        // 2.读取配置文件信息
        String user= props.getProperty("user");
        String password= props.getProperty("password");
        String url= props.getProperty("url");
        String driverClass= props.getProperty("driverClass");

        // 3.加载驱动
        Class.forName(driverClass);

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
}
