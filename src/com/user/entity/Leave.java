package com.user.entity;

import java.sql.Timestamp;


public class Leave {
    private int s_id;
    private String Category;
    private Timestamp Start_Time;
    private Timestamp End_Time;
    private String L_School;
    private String LinkManNum;
    private String Destination;
    private String Reason;
    private String Status;

    @Override
    public String toString() {
        return "Leave{" +
                "s_id=" + s_id +
                ", Category='" + Category + '\'' +
                ", Start_Time=" + Start_Time +
                ", End_Time=" + End_Time +
                ", L_School='" + L_School + '\'' +
                ", LinkManNum='" + LinkManNum + '\'' +
                ", Destination='" + Destination + '\'' +
                ", Reason='" + Reason + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }

    public Leave() {
         s_id=1;
         Category="22";
         Start_Time= Timestamp.valueOf("2022-7-1 16:50:00");
         End_Time= Timestamp.valueOf("2022-7-1 16:50:00");
         L_School="22";
         LinkManNum="22";
         Destination="22";
          Reason="22";
         Status="22";
    }

    public Leave(int s_id, String category, Timestamp start_Time, Timestamp end_Time, String l_School, String linkManNum, String destination, String reason, String status) {
        this.s_id = s_id;
        Category = category;
        Start_Time = start_Time;
        End_Time = end_Time;
        L_School = l_School;
        LinkManNum = linkManNum;
        Destination = destination;
        Reason = reason;
        Status = status;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public Timestamp getStart_Time() {
        return Start_Time;
    }

    public void setStart_Time(Timestamp start_Time) {
        Start_Time = start_Time;
    }

    public Timestamp getEnd_Time() {
        return End_Time;
    }

    public void setEnd_Time(Timestamp end_Time) {
        End_Time = end_Time;
    }

    public String getL_School() {
        return L_School;
    }

    public void setL_School(String l_School) {
        L_School = l_School;
    }

    public String getLinkManNum() {
        return LinkManNum;
    }

    public void setLinkManNum(String linkManNum) {
        LinkManNum = linkManNum;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
