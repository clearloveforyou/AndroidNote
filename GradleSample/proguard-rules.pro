# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\Application\Android\android-sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


#在这里添加项目的代码混淆规则

###############################一般使用得默认混淆#####################################


#混淆第三方库
-dontskipnonpubliclibraryclasses
#代码混淆压缩比，值在0~7之间，默认为5
-optimizationpasses 5
#不使用大小写混淆类名，混淆后的类名为小写
-dontusemixedcaseclassnames
#混淆时记录日志，有助于排查错误
-verbose
#混淆时允许访问并修改有修饰符的类和类成员
-allowaccessmodification
#代码混淆使用的算法
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*


###################################不混淆########################################


#这些类不被混淆
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.support.v4.app.Fragment
-keep public class * extends android.support.v4.app.DialogFragment
-keep public class * extends android.app.Fragment
-keep public class com.android.vending.licensing.ILicensingService

#Native方法不混淆
-keepclasseswithmembernames class * {
    native <methods>;
}

#自定义组件不混淆
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

#自定义控件类和类的成员不混淆（所有指定的类和类成员是要存在的）
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

#同上
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

#自定义控件类不混淆
-keepclassmembers class * extends android.app.Activity {
    public void *(android.view.View);
}

#枚举类不被混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

#Parcelable 不被混淆
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

#R文件的静态成员
-keepclassmembers class **.R$* {
    public static <fields>;
}

##注解继承类不混淆
#-keep class * extends java.lang.annotation.Annotation {*;}
#
##保持Serializable实现类不被混淆
#-keepnames class * implements java.io.Serializable

#android support.v4/v7包不混淆
-keep class android.support.** { *; }
-keep class android.support.v4.** { *; }
-keep public class * extends android.support.v4.**
-keep interface android.support.v4.app.** { *; }
-keep class android.support.v7.** { *; }
-keep public class * extends android.support.v7.**
-keep interface android.support.v7.app.** { *; }

#打包时忽略警告
-dontwarn android.support.**

##################################第三方库的混淆######################################

#如果你的项目中用了第三方库，请参考其官方文档说明进行混淆

#####支付宝混淆START#####



#####支付宝混淆END#####

#####高德地图混淆START#####



#####高德地图混淆END#####














