package com.greenhand.androidnote;

import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;

/**
 * project: AndroidNote
 * package: com.greenhand.androidnote
 * author: HouShengLi
 * time: 2017/4/18 12:28
 * e-mail:13967189624@163.com
 * description:
 */

public abstract class AdsCallBack extends Callback<AdsBanner> {
    @Override
    public AdsBanner parseNetworkResponse(Response response, int id) throws Exception {

        String s = response.body().string();

        return JsonUtils.getT(s, AdsBanner.class);
    }
}
