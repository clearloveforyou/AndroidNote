package com.greenhand.androidnote.httpcallback;

import com.greenhand.androidnote.info.DetilsInfo;
import com.greenhand.androidnote.utils.JsonUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * project: AndroidNote
 * package: com.greenhand.androidnote.httpcallback
 * author: HouShengLi
 * time: 2017/4/21 17:18
 * e-mail:13967189624@163.com
 * description:
 */

public abstract class DetilsCallBack extends Callback<DetilsInfo> {

    @Override
    public DetilsInfo parseNetworkResponse(Response response, int id) throws Exception {

        String s = response.body().string();
        return JsonUtils.getT(s,DetilsInfo.class);
    }
}
