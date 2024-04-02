package com.user.entity;

public class Teacher {
    public int t_id;
    private String sort;
    private String t_name;
    private String job;
    private String class_;
    private String college;
    private String gender;

    public Teacher(int t_id, String sort, String t_name, String job, String class_, String college, String gender) {
        this.t_id = t_id;
        this.sort = sort;
        this.t_name = t_name;
        this.job = job;
        this.class_ = class_;
        this.college = college;
        this.gender = gender;
    }

    public Teacher(){

    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getClass_() {
        return class_;
    }

    public void setClass_(String class_) {
        this.class_ = class_;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "t_id=" + t_id +
                ", sort='" + sort + '\'' +
                ", t_name='" + t_name + '\'' +
                ", job='" + job + '\'' +
                ", class_='" + class_ + '\'' +
                ", college='" + college + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
