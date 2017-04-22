package com.greenhand.androidnote.httpcallback;

import com.greenhand.androidnote.info.TabBean;
import com.greenhand.androidnote.utils.JsonUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;

/**
 * project: AndroidNote
 * package: com.greenhand.androidnote
 * author: HouShengLi
 * time: 2017/4/19 11:30
 * e-mail:13967189624@163.com
 * description:
 */

public abstract class TabsCallBack extends Callback<TabBean> {

    @Override
    public TabBean parseNetworkResponse(Response response, int id) throws Exception {

        String s = response.body().string();
        return JsonUtils.getT(s,TabBean.class);
    }
}
