package com.greenhand.androidnote;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * AS默认使用gradle构建项目，本模块将带领我们认识Gradle:项目构建工具
 * 1.了解gradle：
 * 特点：
 * 相关概念：
 * Project(项目)
 * Task(任务)：编译、复制、打包等
 * Plugin(插件)：所有的特性都有插件完成：如为项目添加依赖
 * 构建gradle包含的几个文件：
 * build.gradle(构建脚本)：指定了一个项目极其任务
 * gradle.properties(属性文件)：用来配置构建的属性
 * setting.gradle(设置文件)：描述了那些模块参与构建
 * 依赖的仓库：
 * 默认jcenter():一个新的远程中央仓库，兼容Maven仓库，性能更优
 * Maven:3个别名：mavenCentral()、jcenter()、mavenLocal()
 * 配置Gradle:----------
 * 2.电脑上不单独配置gradle也没关系，因为As使用的Gradle Wrapper
 * 它可以使我们的在没有安装gradle的时候进行项目构建---why?那就得认识gradle wrapper
 * 3.Gradle Wrapper:
 * 认识：可以理解为gradle的一层封装，让我们在没有安装gradle的操作系统上使用gradle构建项目
 * 如何实现：通过俩个脚本文件
 * 1.gradlew:通过该文件执行gradle的构建与直接使用gradle构建是一样的
 * 2.gradlew.bat:
 * AS为我们自动生成了Gradle Wrapper文件结构：
 * gradle/wrapper:
 * gradle-wrapper.jar:
 * gradle-wrapper.properties:声明了gradle的版本和下载地址
 * 第一次使用gradlew执行gradle构建时，Gradle Wrapper会自动下载 gradle-wrapper.properties指定的gradle版本
 * 4.AS中的Gradle Script:
 * build.gradle:项目构建的配置文件------我在里面详细说明了
 * build.gradle:模块构建的配置文件------我在里面详细说明了
 * gradle-wrapper.properties：Gradle Wrapper的配置文件
 * proguard-rules.pro:混淆规则配置文件
 * gradle.properties：gradle配置文件
 * setting.gradle：-----
 * local.properties:SDK、NDK路径配置文件
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.img_home_search)
    ImageView imgHomeSearch;
    @BindView(R.id.rv_home)
    RecyclerView rvHome;

    private List<String> imgUrls;
    private List<TabBean.DataBean> tabBeanList;
    private List<Flowers.DataBean> flowersList;
    private HomeRvAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //黄油刀注入
        ButterKnife.bind(this);
        //获取数据
        initData();
        //创建rv适配器

        rvHome.setLayoutManager(new LinearLayoutManager(this));

        /**
         * 添加分割线
         */
        rvHome.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(this)
                        .color(Color.parseColor("#f5f0f0"))
                        .size(20)
                        .build());

        //
        rvAdapter = new HomeRvAdapter(imgUrls,tabBeanList,flowersList,this);
        rvHome.setAdapter(rvAdapter);
    }

    private void initData() {

        imgUrls = new ArrayList<>();
        tabBeanList = new ArrayList<>();
        flowersList = new ArrayList<>();
        //banner
        OkHttpUtils.post()
                .url(Constant.HOME_BANNER_POST_URL)
                .addParams(Constant.APKEY, "appbanner33")
                .tag(this)
                .build()
                .execute(new AdsCallBack() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(AdsBanner response, int id) {

                        AdsBanner.DataBean dataBean = response.getData().get(0);
                        List<AdsBanner.DataBean.AdvListBean> advList = dataBean.getAdvList();

                        for (int i = 0,len = advList.size();i<len;i++){
                            AdsBanner.DataBean.AdvListBean bean = advList.get(i);
                            imgUrls.add(Constant.FUWUQI_DE+bean.getResUrl());
                        }

                        rvAdapter.notifyDataSetChanged();
                    }
                });

        //
        OkHttpUtils.get()
                .url(Constant.HOME_GUIDE_GET_URL)
                .tag(this)
                .build()
                .execute(new TabsCallBack() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(TabBean response, int id) {

                        tabBeanList.addAll(response.getData());

                        rvAdapter.notifyDataSetChanged();
                    }
                });

        OkHttpUtils.get()
                .url(Constant.HOME_LIST_SHOW_GET_URL)
                .tag(this)
                .build()
                .execute(new FlowerCallBack() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(Flowers response, int id) {

                        List<Flowers.DataBean> data = response.getData();
                        flowersList.addAll(data);

                        rvAdapter.notifyDataSetChanged();
                    }
                });
    }
}
