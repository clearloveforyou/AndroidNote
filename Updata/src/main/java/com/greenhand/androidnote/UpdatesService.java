package com.greenhand.androidnote;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.support.v4.os.ResultReceiver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class UpdatesService extends IntentService {

    private static final String DOWN_LOAD_URL = "downUrl";
    private static final String APK_NAME = "apkName";
    public static final String RECEIVER = "receiver";
    /* 下载中 */
    private static final int DOWNLOAD = 1;
    /* 下载结束 */
    private static final int DOWNLOAD_FINISH = 2;
    private boolean cancel = false;


    public UpdatesService() {
        super("UpdatesService");
    }

    public static void startActionFoo(Context context, ResultReceiver receiver, String apkName, String downUrl) {
        Intent intent = new Intent(context, UpdatesService.class);
        intent.putExtra(APK_NAME, apkName);
        intent.putExtra(DOWN_LOAD_URL, downUrl);
        intent.putExtra(RECEIVER,receiver);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String downUrl = intent.getStringExtra(DOWN_LOAD_URL);
        String apkName = intent.getStringExtra(APK_NAME);
        ResultReceiver receiver = intent.getParcelableExtra(RECEIVER);
        Bundle bundle = new Bundle();
        bundle.putString("apk",apkName);
        try {
            // 判断SD卡是否存在，并且是否具有读写权限
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                // 获得存储卡的路径
                String sdpath = Environment.getExternalStorageDirectory() + "/";
                String mSavePath = sdpath + "download";
                //
                bundle.putString("path",mSavePath);
                URL url = new URL(downUrl);
                // 创建连接
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();
                // 获取文件大小
                int length = conn.getContentLength();
                // 创建输入流
                InputStream is = conn.getInputStream();

                File file = new File(mSavePath);
                // 判断文件目录是否存在
                if (!file.exists()) {
                    file.mkdir();
                }
                File apkFile = new File(mSavePath, apkName);
                if (apkFile.exists()){
                    apkFile.delete();
                }
                FileOutputStream fos = new FileOutputStream(apkFile);
                int count = 0;
                // 缓存
                byte buf[] = new byte[1024];
                // 写入到文件中
                while (!cancel) {

                    int numread = is.read(buf);
                    count += numread;
                    // 计算进度条位置
                    int progress = (int) (((float) count / length) * 100);
                    // 更新进度
                    bundle.putInt("ps",progress);
                    receiver.send(DOWNLOAD,bundle);
                    if (numread <= 0) {
                        // 下载完成
                        receiver.send(DOWNLOAD_FINISH,bundle);
                        break;
                    }
                    // 写入文件
                    fos.write(buf, 0, numread);
                    fos.flush();
                }

                fos.close();
                is.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
