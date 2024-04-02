package com.user.entity;

public class FeedBack {
    private int f_id;
    private String s_id;
    private String type;
    private String reason;

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public FeedBack(int f_id, String s_id, String type, String reason) {
        this.f_id = f_id;
        this.s_id = s_id;
        this.type = type;
        this.reason = reason;
    }

    public FeedBack() {
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "f_id=" + f_id +
                ", s_id='" + s_id + '\'' +
                ", type='" + type + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
