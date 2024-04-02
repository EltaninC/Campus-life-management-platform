package com.user.entity;

public class Course {
    private int c_id;
    private int t_id;
    private int week;
    private int node;
    private String course_name;

    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "c_id=" + c_id +
                ", t_id=" + t_id +
                ", week=" + week +
                ", node=" + node +
                ", course_name='" + course_name + '\'' +
                '}';
    }

    public Course(int c_id, int t_id, int week, int node, String course_name) {
        this.c_id = c_id;
        this.t_id = t_id;
        this.week = week;
        this.node = node;
        this.course_name = course_name;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
}
