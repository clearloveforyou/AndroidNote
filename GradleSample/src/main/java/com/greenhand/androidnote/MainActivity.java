package com.greenhand.androidnote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * AS默认使用gradle构建项目，本模块将带领我们认识Gradle:项目构建工具
 * 1.了解gradle：
 *              特点：
 *              相关概念：
 *                      Project(项目)
 *                      Task(任务)：编译、复制、打包等
 *                      Plugin(插件)：所有的特性都有插件完成：如为项目添加依赖
 *              构建gradle包含的几个文件：
 *                                  build.gradle(构建脚本)：指定了一个项目极其任务
 *                                  gradle.properties(属性文件)：用来配置构建的属性
 *                                  setting.gradle(设置文件)：描述了那些模块参与构建
 *              依赖的仓库：
 *                          默认jcenter():一个新的远程中央仓库，兼容Maven仓库，性能更优
 *                          Maven:3个别名：mavenCentral()、jcenter()、mavenLocal()
 *              配置Gradle:----------
 * 2.电脑上不单独配置gradle也没关系，因为As使用的Gradle Wrapper
 *   它可以使我们的在没有安装gradle的时候进行项目构建---why?那就得认识gradle wrapper
 * 3.Gradle Wrapper:
 *          认识：可以理解为gradle的一层封装，让我们在没有安装gradle的操作系统上使用gradle构建项目
 *          如何实现：通过俩个脚本文件
 *                  1.gradlew:通过该文件执行gradle的构建与直接使用gradle构建是一样的
 *                  2.gradlew.bat:
 *          AS为我们自动生成了Gradle Wrapper文件结构：
 *                  gradle/wrapper:
 *                                 gradle-wrapper.jar:
 *                                 gradle-wrapper.properties:声明了gradle的版本和下载地址
 *          第一次使用gradlew执行gradle构建时，Gradle Wrapper会自动下载 gradle-wrapper.properties指定的gradle版本
 * 4.AS中的Gradle Script:
 *          build.gradle:项目构建的配置文件------我在里面详细说明了
 *          build.gradle:模块构建的配置文件------我在里面详细说明了
 *          gradle-wrapper.properties：Gradle Wrapper的配置文件
 *          proguard-rules.pro:混淆规则配置文件
 *          gradle.properties：gradle配置文件
 *          setting.gradle：-----
 *          local.properties:SDK、NDK路径配置文件
 *
 *
 *
 *
 *
 *
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
