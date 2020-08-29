package com.wang.standardCon;

import org.junit.Test;

/**
 *
 * 通用的版本
 * @author WangDebao
 * @create 2020-08-28 10:51
 */
public class CURDTest {

    /**
     * 实现insert操作
     */
    @Test
    public void ConTest01() throws Exception {

        String sql = "insert into course values(?,?,?,?)";
        JDBCUtils.update(sql, 8,"C语言",null,4);

    }

    /**
     * 实现delete操作
     */
    @Test
    public void ConTest02(){
        String sql = "delete from course where cno=?";
        JDBCUtils.update(sql, 7);
    }

    /**
     * 实现update操作
     */
    @Test
    public void ConTest03(){
        String sql = "update course set ccredit=? where cno=?";
        JDBCUtils.update(sql, 4,2);
    }
}
