package com.user.entity;

public class Repairform {
    private int r_id;
    private String s_id;
    private String r_time;
    private String r_space;
    private String r_type;
    private String r_content;

    public Repairform() {
    }

    public Repairform(int r_id, String s_id, String r_time, String r_space, String r_type, String r_content) {
        this.r_id = r_id;
        this.s_id = s_id;
        this.r_time = r_time;
        this.r_space = r_space;
        this.r_type = r_type;
        this.r_content = r_content;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getR_time() {
        return r_time;
    }

    public void setR_time(String r_time) {
        this.r_time = r_time;
    }

    public String getR_space() {
        return r_space;
    }

    public void setR_space(String r_space) {
        this.r_space = r_space;
    }

    public String getR_type() {
        return r_type;
    }

    public void setR_type(String r_type) {
        this.r_type = r_type;
    }

    public String getR_content() {
        return r_content;
    }

    public void setR_content(String r_content) {
        this.r_content = r_content;
    }

    @Override
    public String toString() {
        return "Repairform{" +
                "r_id=" + r_id +
                ", s_id='" + s_id + '\'' +
                ", r_time='" + r_time + '\'' +
                ", r_space='" + r_space + '\'' +
                ", r_type='" + r_type + '\'' +
                ", r_content='" + r_content + '\'' +
                '}';
    }
}
