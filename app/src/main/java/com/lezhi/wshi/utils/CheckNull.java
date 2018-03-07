package com.lezhi.wshi.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Author: {王二星}
 * Date: 2017/4/26
 * Description: 任意对象判断为空
 */

public class CheckNull {

    public static boolean getBody(Object object) {
        if (object != null && !object.equals("") && !object.equals("null")) {
            if (object instanceof Collection) {
                if (((List) object).size() > 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (object instanceof Map) {
                if (((Map) object).size() > 0) {
                    return true;
                } else {
                    return false;
                }
            }else if (object instanceof String){
                if(((String) object).length()>0){
                    return true;
                }else {
                    return false;
                }
            }else if (object instanceof Integer){
                if ((Integer)object!=-1){
                    return true;
                }else{
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
