package com.lezhi.wshi.module.entity;

import java.io.Serializable;

/**
 * @author   Administrator on 2017/1/13 0013.
 */

public class UserSearchCache implements Serializable {
    private String searchKey;

    @Override
    public String toString() {
        return "UserSearchCache{" +
                "searchKey='" + searchKey + '\'' +
                '}';
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}

