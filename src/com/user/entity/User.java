package com.user.entity;

public class User {
    private int u_id;
    private String account;
    private String password;
    private String sort;

    public User(int u_id, String account, String password, String sort) {
        this.u_id = u_id;
        this.account = account;
        this.password = password;
        this.sort = sort;
    }
    public User(){}
    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }
}
