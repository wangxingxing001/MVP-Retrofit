package com.lezhi.wshi.module;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.lezhi.wshi.db.wshi_db;

import java.util.HashSet;
import java.util.Set;

/**
 * @author  ${王二星} on 2017/4/20 0020.
 *
 */

public class BaseApplication extends Application {

    private static BaseApplication _instance;
    private static wshi_db dbHelper;
    private Set<Activity> allActivities;

    public static BaseApplication getInstance() {
        return _instance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // 分包
        MultiDex.install(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        _instance = this;
    }

    public void registerActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<Activity>();
        }
        allActivities.add(act);
    }

    public void unregisterActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    if (act != null && !act.isFinishing())
                        act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    // 获取数据库实例Uhn
    public static wshi_db getDBHelper(){
        if(dbHelper==null)
            dbHelper = wshi_db.getInstance(_instance);
        return dbHelper;
    }
}
