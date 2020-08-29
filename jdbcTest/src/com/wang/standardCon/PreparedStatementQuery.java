package com.wang.standardCon;

import com.wang.bean.Customers;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 使用PreparedStatement实现针对不同表的通用的查询操作
 * @author WangDebao
 * @create 2020-08-29 13:57
 */
public class PreparedStatementQuery {

    public <T> List<T> getInstance(Class<T> clazz,String sql, Object ...args){
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
            // 创建集合对象
            ArrayList<T> list = new ArrayList<T>();
            while (rs.next()){
                T t = clazz.newInstance();
                // 给t对象指定的属性赋值
                for (int i = 0; i < columnCount; i++) {
                    // 获取结果集的列的值
                    Object columnValue = rs.getObject(i + 1);

                    // 获取列名：getColumnName()
                    // 获取列的别名：getColumnLabel()
//                    String columnName = rsmd.getColumnName(i + 1);
                    String columnName = rsmd.getColumnLabel(i + 1);

                    // 通过反射将对象指定名的columnName赋值为columnValue
                    Field f = clazz.getDeclaredField(columnName);
                    f.setAccessible(true);
                    f.set(t, columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;

    }


    @Test
    public void Test01(){
        String sql = "select id,name,email,birth from customers";
        List <Customers> list =  getInstance(Customers.class, sql);
        list.forEach(System.out::println);
        System.out.println(list);

    }
}
