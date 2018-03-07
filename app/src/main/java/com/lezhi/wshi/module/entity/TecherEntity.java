package com.lezhi.wshi.module.entity;

import java.io.Serializable;

/**
 * @author   ${二星} on 2017/5/8 0008.
 */

public class TecherEntity implements Serializable{

    private String title;
    private String UserName;
    private String zy;

    public TecherEntity(String title, String zy, String userName) {
        this.title = title;
        this.zy = zy;
        UserName = userName;
    }

    @Override
    public String toString() {
        return "TecherEntity{" +
                "title='" + title + '\'' +
                ", UserName='" + UserName + '\'' +
                ", zy='" + zy + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }
}
