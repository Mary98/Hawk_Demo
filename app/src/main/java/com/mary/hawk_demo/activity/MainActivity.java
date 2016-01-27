package com.mary.hawk_demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mary.hawk_demo.R;
import com.mary.hawk_demo.bean.User;
import com.mary.hawk_fastjson_lib.Hawk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button btnRead, btnReplace, btnRemove, btnContains;
    private TextView tvTag01, tvTag02, tvTag03, tvTag04, tvTag05;

    // 数据部分
    private ArrayList<User> arrayList;
    private HashMap<String, List<User>> hashMap;
    private HashSet<User> hashSet;
    private User user;
    private String message;

    // key部分
    private String key_arrayList = "arrayList";
    private String key_hashMap   = "hashMap";
    private String key_hashSet   = "hashSet";
    private String key_user      = "user";
    private String key_message    = "测试1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();// 初始化视图
        readFromHawk();// 读取Hawk数据库
    }

    /**
     * 读取Hawk数据库
     */
    private void readFromHawk() {
        arrayList = Hawk.get(key_arrayList);
        hashMap   = Hawk.get(key_hashMap);
        hashSet   = Hawk.get(key_hashSet);
        user      = Hawk.get(key_user);
        message   = Hawk.get(key_message);
        /*
         当获取为null的时候设置 默认值
         T result = Hawk.get(key, T);
         例：
            String result = Hawk.get(key, "你还在吗？");
         */
    }

    /**
     * 初始化视图
     */
    private void initView() {
        btnRead = (Button) this.findViewById(R.id.id_btn_Read);
        btnRead.setOnClickListener(this);
        btnReplace = (Button) this.findViewById(R.id.id_btn_Replace);
        btnReplace.setOnClickListener(this);
        btnRemove = (Button) this.findViewById(R.id.id_btn_Remove);
        btnRemove.setOnClickListener(this);
        btnContains = (Button) this.findViewById(R.id.id_btn_Contains);
        btnContains.setOnClickListener(this);

        tvTag01 = (TextView) this.findViewById(R.id.id_tv_Tag01);
        tvTag02 = (TextView) this.findViewById(R.id.id_tv_Tag02);
        tvTag03 = (TextView) this.findViewById(R.id.id_tv_Tag03);
        tvTag04 = (TextView) this.findViewById(R.id.id_tv_Tag04);
        tvTag05 = (TextView) this.findViewById(R.id.id_tv_Tag05);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.id_btn_Read:
                read(v);
                break;
            case R.id.id_btn_Replace:
                replace(v);
                break;
            case R.id.id_btn_Remove:
                remove(v);
                break;
            case R.id.id_btn_Contains:
                contains(v);
                break;
        }
    }

    /**
     * 判断是否包含某个key
     * @param view
     */
    private void contains(View view) {
        boolean contains = Hawk.contains(key_message);
    }

    /**
     * 移除数据
     * @param view
     */
    private void remove(View view) {
        // Returns the result as boolean
        Hawk.remove(key_message);
        /*
         同时移除多个数据
         Hawk.remove("key1", "key2", "key3");
         */
    }

    /**
     * 替换
     * @param view
     */
    private void replace(View view) {
        // Returns the result as boolean
        Hawk.put(key_message, "嗯嗯，还算不错吧，你呢？");
        message   = Hawk.get(key_message);
    }

    /**
     * 设置读取后显示的数据(数据来自Hawk数据库)
     * @param view
     */
    private void read(View view) {
        tvTag01.setText("arrayList:" + arrayList.toString());
        tvTag02.setText("hashMap:" + hashMap.toString());
        tvTag03.setText("hashSet:" + hashSet.toString());
        tvTag04.setText("user:" + user.toString());
        tvTag05.setText("message:" + message);
    }

}
