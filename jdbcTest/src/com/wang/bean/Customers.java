package com.wang.bean;

import java.sql.Date;

/**
 *
 * ORM(object relational mapping)
 * 一个数据表对应一个java类
 * 表中的一个记录对应一个java类的对象
 * 一个字段对应java类的一个属性
 * @author WangDebao
 * @create 2020-08-29 09:52
 */
public class Customers {


    private int id;
    private String name;
    private String email;
    private Date birth;

    public Customers() {
    }

    public Customers(int id, String name, String email, Date birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", date=" + birth +
                '}';
    }
}
