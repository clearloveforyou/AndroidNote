package com.greenhand.androidnote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login();

        share();

        pay();

        bug();

        http();

        imgloader();

        list();

        check();

        set("","");
    }

    /**
     * 字符串反转
     * @param s 输入的字符串
     * @param s1 反转的内容
     * @return 完成的字符串
     */
    private String set(String s, String s1) {


        return null;

    }

    private void check() {

        /**
         * 校检
         */

        /**
         * 校检2
         */
    }

    /**
     * hello
     */
    private void list() {

        /**
         * 添加了list
         */
    }

    private void imgloader() {

        /**
         * 增加了图片请求
         */
    }

    private void http() {

        /**
         * 增加了网络请求
         */
    }

    private void bug() {

        /**
         * 增加了bug统计
         */
    }

    private void pay() {


        //增加了支付功能
    }

    private void share() {

        //
        shareQQ();

        //
        shareWechat();

    }

    private void shareWechat() {

    }

    private void shareQQ() {

    }

    private void login() {


        /**
         * app登录
         */
    }
}
