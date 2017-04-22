package com.greenhand.androidnote.utils;

/**
 * project: AndroidNote
 * package: com.greenhand.androidnote
 * author: HouShengLi
 * time: 2017/4/18 10:18
 * e-mail:13967189624@163.com
 * description: url
 */

public class Constant {

    ////////////////////////////////服务器域名/////////////////////////////

    public static final String FUWUQI_DE = "http://www.acggou.com";

    ///////////////////////////////广告栏url/////////////////////////////

    public static final String HOME_BANNER_POST_URL = "http://www.acggou.com/api/v2/adv/adv";
    public static final String APKEY = "apKey";//appbanner33

    ///////////////////////////////新品、预定、优选、热卖////////////////////////////

    public static final String HOME_GUIDE_GET_URL = "http://www.acggou.com/api/v2/index/buttons";

    //////////////////////////////////home主要显示的list////////////////////////////////


    public static final String HOME_LIST_SHOW_GET_URL = "http://www.acggou.com/api/v2/index/floors";


    //////////////////////////////////商品详情////////////////////////////////////////

    public static final String PRODUCT_DETILD_POST_URL = "http://www.acggou.com/goods/api/goodsdetail";

    //////////////////////////////////商品网页详情////////////////////////////////////

    public static String getWebUrl(String goodsId){

        return "http://www.acggou.com/m/goods/goodsIntroduce?goodsId="+goodsId+"&isShow=0";
    }

}
