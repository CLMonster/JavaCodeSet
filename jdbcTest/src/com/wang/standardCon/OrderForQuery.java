package com.wang.standardCon;

import com.wang.bean.Order;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * 对于表的字段名和类的属性名不同的情况
 *  1.必须声明sql时，使用类的属性名来命名类的别名
 *  2.使用ResultMetaData时，需要使用getColumnLabel()来代替getColumnName()，获取列的别名
 *      说明：如果在sql中没有给列起别名，getColumnLabel()获取的是列名
 *
 * @author WangDebao
 * @create 2020-08-29 13:17
 */
public class OrderForQuery {


    /**
     * 通用的针对Order表的查询操作
     * @param sql
     * @param args
     * @return
     */
    public Order orderForQuery(String sql, Object ... args)  {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }

            // 执行,获取结果集
            rs = ps.executeQuery();
            // 获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            // 获取列数
            int columnCount = rsmd.getColumnCount();
            if(rs.next()){
                Order order = new Order();
                for (int i = 0; i < columnCount; i++) {
                    // 获取结果集的列的值
                    Object columnValue = rs.getObject(i + 1);

                    // 获取列名：getColumnName()
                    // 获取列的别名：getColumnLabel()
//                    String columnName = rsmd.getColumnName(i + 1);
                    String columnName = rsmd.getColumnLabel(i + 1);

                    // 通过反射将对象指定名的columnName赋值为columnValue
                    Field f = Order.class.getDeclaredField(columnName);
                    f.setAccessible(true);
                    f.set(order, columnValue);
                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }

        return null;
    }


    /**
     * 测试
     * @throws Exception
     */
    @Test
    public void testOrdercon() throws Exception {
        String sql = "select order_id orderId,order_date orderDate from `order` where order_id = ?";
        Order order = orderForQuery(sql, 1);
        System.out.println(order);


    }
}
