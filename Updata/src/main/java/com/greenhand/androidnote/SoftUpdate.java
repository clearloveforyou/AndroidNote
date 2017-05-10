package com.greenhand.androidnote;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;

/**
 * project: AndroidNote
 * package: com.greenhand.androidnote
 * author: HouShengLi
 * time: 2017/5/8 20:40
 * e-mail:13967189624@163.com
 * description:
 */

public class SoftUpdate {

    /* 下载中 */
    private static final int DOWNLOAD = 1;
    /* 下载结束 */
    private static final int DOWNLOAD_FINISH = 2;


    private String apkName;
    private Activity activity;
    /* 更新进度条 */
    private ProgressBar mProgress;
    private Dialog mDownloadDialog;
    /* 下载保存路径 */
    String sdpath = Environment.getExternalStorageDirectory() + "/";
    String mSavePath = sdpath + "download";

    public static final int MY_WRITE_EXTERNAL_STORAGE = 110;

    public SoftUpdate(Activity activity) {
        this.activity = activity;
    }

    public ResultReceiver receiver = new ResultReceiver(new Handler()) {

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {

            int process = resultData.getInt("ps");
            switch (resultCode) {
                // 正在下载
                case DOWNLOAD:
                    // 设置进度条位置
                    mProgress.setProgress(process);
                    break;
                case DOWNLOAD_FINISH:
                    //进度条消失
                    mDownloadDialog.dismiss();
                    // 安装文件
                    installAPK(activity);
                    break;
            }
        }
    };


    /**
     * 检查软件是否有更新版本
     *
     * @return
     */
    public boolean isUpdate(int newVersionCode) {
        // 获取当前软件版本
        int versionCode = getVersionCode(activity);

        if (newVersionCode > versionCode) {
            return true;
        }

        return false;
    }

    /**
     * 获取软件版本号
     *
     * @param context
     * @return
     */
    private int getVersionCode(Context context) {
        int versionCode = 1;
        try {
            //获取版本号
            versionCode = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0)
                    .versionCode;

        } catch (Exception e) {

            e.printStackTrace();
            Toast.makeText(context, "" + "未获得版本号", Toast.LENGTH_SHORT).show();
        }

        return versionCode;
    }

    /**
     * 显示软件更新对话框
     */
    public void showNoticeDialog(final String apk, final String url) {

        apkName = apk;
        // 构造对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.soft_update_title);//软件更新
        builder.setMessage(R.string.soft_update_info);//检测到新版本，立即更新吗
        // 更新
        builder.setPositiveButton(R.string.update, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

                if (isSelfPermission(activity)) {
                    // 显示下载对话框
                    showDownloadDialog(activity);
                    UpdatesService.startActionFoo(activity,receiver,apk,url);
                }

            }
        });
        // 稍后更新
        builder.setNegativeButton(R.string.soft_update_later, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        Dialog noticeDialog = builder.create();
        noticeDialog.show();
    }

    /**
     * 显示软件下载对话框
     */
    public void showDownloadDialog(Activity activity) {
        // 构造软件下载对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.soft_updating);//正在更新
        // 给下载对话框增加进度条
        final LayoutInflater inflater = LayoutInflater.from(activity);
        View v = inflater.inflate(R.layout.soft_update, null);
        mProgress = (ProgressBar) v.findViewById(R.id.update_progress);
        builder.setView(v);
        // 取消更新
        builder.setNegativeButton(R.string.soft_update_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        mDownloadDialog = builder.create();
        mDownloadDialog.show();

    }

    private boolean isSelfPermission(Activity activity) {

        boolean isHas = true;

        //动态请求android6.0权限
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.READ_CONTACTS)) {


            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_WRITE_EXTERNAL_STORAGE);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }

            isHas = false;
        }

        return isHas;
    }

    private void installAPK(Context context) {
        File file = new File(mSavePath,apkName);
        if (file.exists()) {
            openFile(file, context);
        } else {
            Toast.makeText(context, "下载失败", Toast.LENGTH_SHORT).show();
        }
    }

    private void openFile(File file,Context context) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(android.content.Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file),
                "application/vnd.android.package-archive");
        context.startActivity(intent);
    }
}
