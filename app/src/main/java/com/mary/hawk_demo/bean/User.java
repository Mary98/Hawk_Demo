package com.mary.hawk_demo.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/27.
 */
public class User {

    private String name;
    private int age;
    private Object info;
    private List<String> sum;

    public User() {

    }

    public User(String name, int age, Object info, List<String> sum) {
        this.name = name;
        this.age = age;
        this.info = info;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", info=" + info +
                ", sum=" + sum +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public List<String> getSum() {
        return sum;
    }

    public void setSum(List<String> sum) {
        this.sum = sum;
    }
}
