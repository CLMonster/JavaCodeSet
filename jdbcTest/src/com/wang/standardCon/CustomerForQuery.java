package com.wang.standardCon;

import com.wang.bean.Customers;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author WangDebao
 * @create 2020-08-29 09:25
 */
public class CustomerForQuery {

    /**
     * 一般的查询
     */
    @Test
    public void TestQuery01() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // 获取数据库连接
            conn = JDBCUtils.getConnection();
            // 预编译sql
            String sql = "select * from customers where id = ?";
            ps = conn.prepareStatement(sql);
            // 填充占位符
            ps.setObject(1, 1);
            // 执行，返回结果集
            rs = ps.executeQuery();
            // 处理结果集
            while (rs.next()) { // next() 光标的初始位置在第一行之前，每次判断下一行是否有数据，如果有数据返回true，光标会下移一行，以此类推。

                // 获取数据
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                Date date = rs.getDate(4);

                // 打印数据
//            System.out.println("id= "+ id + "，name= "+ name + "，email= "+ email + "，date= " + date);

                // 处理数据，我们创建一个javaBean:Customers.java，创建对象
                // 将数据封装成一个对象
                Customers customers = new Customers(id, name, email, date);
                System.out.println(customers);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源  resultSet对象也需要关闭
            JDBCUtils.closeResource(conn, ps, rs);
        }
    }

    @Test
    public void OrderQuery(){

    }
}
