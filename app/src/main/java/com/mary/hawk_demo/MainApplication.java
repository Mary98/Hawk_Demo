package com.mary.hawk_demo;

import android.app.Application;

import com.mary.hawk_fastjson_lib.Hawk;
import com.mary.hawk_fastjson_lib.HawkBuilder;
import com.mary.hawk_fastjson_lib.LogLevel;

/**
 * Created by Mary on 16/1/27.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化Hawk(初始化一次就可以，通常在启动Activity或者Application中)
        Hawk.init(this)
                .setEncryptionMethod(HawkBuilder.EncryptionMethod.MEDIUM)// 中安全级别
                .setStorage(HawkBuilder.newSqliteStorage(this))// 使用Sqlite储存
                .setLogLevel(LogLevel.FULL)
                .build();

        // 能使用高安全级别  初始化可能需要 36-400ms 并且需要你提供密码
        /*Hawk.init(this)
                .setEncryptionMethod(HawkBuilder.EncryptionMethod.HIGHEST)
                .setStorage(HawkBuilder.newSharedPrefStorage(this))// 使用SharePreference储存
                .setLogLevel(LogLevel.FULL)
                .build();*/

        /*Hawk.init(this)
                .setEncryptionMethod(HawkBuilder.EncryptionMethod.HIGHEST)
                .setPassword("MynameisMary")
                .setStorage(HawkBuilder.newSqliteStorage(this))
                .setLogLevel(LogLevel.FULL)
                .setCallback(new HawkBuilder.Callback(){

                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onFail(Exception e) {

                    }
                })
                .build();*/


    }

}
