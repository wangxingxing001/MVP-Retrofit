package com.lezhi.wshi.module.entity;

import java.io.Serializable;

/**
 * @author   ${二星} on 2017/5/5 0005.
 */

public class Prodata implements Serializable {
    private String title;
    private String day;
    private String month;
    private String ly;
    private int PID;

    public Prodata(String title, String day, String month, String ly, int PID) {
        this.title = title;
        this.day = day;
        this.month = month;
        this.ly = ly;
        this.PID = PID;
    }

    @Override
    public String toString() {
        return "Prodata{" +
                "title='" + title + '\'' +
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", ly='" + ly + '\'' +
                ", PID=" + PID +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getLy() {
        return ly;
    }

    public void setLy(String ly) {
        this.ly = ly;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }
}
