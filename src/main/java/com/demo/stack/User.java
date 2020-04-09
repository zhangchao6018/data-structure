package com.demo.stack;

/**
 * @描述:
 * @author: zhangchao
 * @date: 4/6/20 11:20 上午
 **/
public class User {
    private String id;

    private String userName;

    public User(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
