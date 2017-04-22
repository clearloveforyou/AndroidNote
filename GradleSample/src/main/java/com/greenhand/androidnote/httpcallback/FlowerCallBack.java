package com.greenhand.androidnote.httpcallback;

import com.greenhand.androidnote.info.Flowers;
import com.greenhand.androidnote.utils.JsonUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;

/**
 * project: AndroidNote
 * package: com.greenhand.androidnote
 * author: HouShengLi
 * time: 2017/4/19 13:45
 * e-mail:13967189624@163.com
 * description:
 */

public abstract class FlowerCallBack extends Callback<Flowers> {
    @Override
    public Flowers parseNetworkResponse(Response response, int id) throws Exception {
        String s = response.body().string();
        return JsonUtils.getT(s,Flowers.class);
    }
}
