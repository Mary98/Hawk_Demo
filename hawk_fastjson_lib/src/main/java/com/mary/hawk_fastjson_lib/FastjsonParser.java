package com.mary.hawk_fastjson_lib;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by Administrator on 2016/1/27.
 */
public class FastjsonParser implements Parser {

    @Override
    public <T> T fromJson(String content, Class<T> type) throws Exception {
        if (TextUtils.isEmpty(content)) {
            return null;
        }
        return JSON.parseObject(content, type);
    }

    @Override
    public <T> List<T> fromJsonList(String content, Class<T> type) throws Exception {
        if (TextUtils.isEmpty(content)) {
            return null;
        }

        return JSON.parseArray(content, type);
    }

    @Override
    public String toJson(Object body) {
        return JSON.toJSONString(body);
    }

    @Override
    public <T> T fromJsonMap(String content, Class<T> type) throws Exception {
        return (T) JSON.parse(content);
    }
}
