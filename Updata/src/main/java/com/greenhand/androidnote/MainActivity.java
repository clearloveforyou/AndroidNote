package com.greenhand.androidnote;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnUpdate;
    public static final int MY_WRITE_EXTERNAL_STORAGE = 110;
    private int newVersionCode = 5;
    private SoftUpdate softUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUpdate = (Button) findViewById(R.id.btn_update);
        softUpdate = new SoftUpdate(this);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 检查软件更新
                if (softUpdate.isUpdate(newVersionCode)) {
                    //显示检测到新版本的对话框
                    softUpdate.showNoticeDialog("jcb","http://dl.hzjcb.com/2.5.0_original.apk");

                } else {
                    Toast.makeText(MainActivity.this, "已经是最新的版本", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == MY_WRITE_EXTERNAL_STORAGE) {
            if (permissions[0].equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    softUpdate.showDownloadDialog(this);
                    UpdatesService.startActionFoo(this,softUpdate.receiver,"jcb","http://dl.hzjcb.com/2.5.0_original.apk");

                } else {
                    Toast.makeText(this, "提示没有权限，安装不了咯", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }



}
