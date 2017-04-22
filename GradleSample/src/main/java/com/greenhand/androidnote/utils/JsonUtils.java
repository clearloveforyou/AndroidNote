package com.greenhand.androidnote.utils;

import com.alibaba.fastjson.JSON;

/**
 * project: AndroidNote
 * package: com.greenhand.androidnote
 * author: HouShengLi
 * time: 2017/4/18 12:13
 * e-mail:13967189624@163.com
 * description:
 */

public class JsonUtils {

    public static <T> T getT(String jsonStr, Class<T> cls) {

        return JSON.parseObject(jsonStr, cls);
    }
}
