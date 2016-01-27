package com.mary.hawk_demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.mary.hawk_fastjson_lib.Hawk;
import com.mary.hawk_demo.R;
import com.mary.hawk_demo.bean.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Administrator on 2016/1/27.
 */
public class SplashActivity extends Activity {

    // 数据部分
    private ArrayList<User> arrayList;
    private HashMap<String, List<User>> hashMap;
    private HashSet<User> hashSet;
    private User user;

    // key部分
    String key_arrayList = "arrayList";
    String key_hashMap   = "hashMap";
    String key_hashSet   = "hashSet";
    String key_user      = "user";

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initData();// 初始化数据
        writerToHawk();// 写入Hawk数据库

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3 * 1000);

    }

    private void writerToHawk() {
        // Returns the result as boolean
        Hawk.put(key_arrayList, arrayList);
        Hawk.put(key_hashMap, hashMap);
        Hawk.put(key_hashSet, hashSet);
        Hawk.put(key_user, user);
        Hawk.put("测试1", "再近还好吗？");
        Hawk.put("测试2", "再次测试");

        /*
         可以通过使用链功能存储多个项目。记得在最后使用commit()。
         Hawk.chain()
            .put(KEY_LIST, List<T>)
            .put(KEY_ANOTHER,"test")
            .commit();
         */

    }

    private void initData() {
        arrayList = new ArrayList<>();
        hashMap = new HashMap<>();
        hashSet = new HashSet<>();
        user = new User("Mary", 1994, "man", new ArrayList<String>());

        for (int i = 0; i  < 15; i++) {
            arrayList.add(new User("arrayList_name:" + i, i, "object:" + i, new ArrayList<String>()));
            hashSet.add(new User("hashSet_name:" + i, i, "object:" + i, new ArrayList<String>()));
        }

        hashMap.put("Mary01", arrayList);
        hashMap.put("Mary02", arrayList);
        hashMap.put("Mary03", arrayList);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Mary", "SplashActivity被销毁了");
    }
}
