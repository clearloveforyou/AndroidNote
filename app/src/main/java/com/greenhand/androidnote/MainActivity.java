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
    }

    private void share() {

        //
        shareQQ();

    }

    private void shareQQ() {

    }

    private void login() {


        /**
         * app登录
         */
    }
}
