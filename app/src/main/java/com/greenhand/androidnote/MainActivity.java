package com.greenhand.androidnote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login();

        share();

        pay();

        bug();
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
