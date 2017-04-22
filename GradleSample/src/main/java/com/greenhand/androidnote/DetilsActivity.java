package com.greenhand.androidnote;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.greenhand.androidnote.adapter.HomeRvAdapter;
import com.greenhand.androidnote.httpcallback.DetilsCallBack;
import com.greenhand.androidnote.info.AdsBanner;
import com.greenhand.androidnote.info.DetilsInfo;
import com.greenhand.androidnote.utils.Constant;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

public class DetilsActivity extends AppCompatActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.cb_detils)
    ConvenientBanner cbDetils;
    @BindView(R.id.txt_detils_desc)
    TextView txtDetilsDesc;
    @BindView(R.id.txt_detils_order)
    TextView txtDetilsOrder;
    @BindView(R.id.txt_detils_allprice)
    TextView txtDetilsAllprice;
    @BindView(R.id.img_detils_icon)
    ImageView imgDetilsIcon;
    @BindView(R.id.wb_detils)
    WebView wbDetils;
    private String goodsId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detils);
        ButterKnife.bind(this);

        //获取传过来的goodId
        goodsId = getIntent().getStringExtra("goodsId");

        //
        initView();
        //
        initData();
        //
        listener();
    }

    private void listener() {

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData() {

        OkHttpUtils.post()
                .url(Constant.PRODUCT_DETILD_POST_URL)
                .addParams("goodsId", goodsId)
                .addParams("memberId", "")
                .tag(this)
                .build()
                .execute(new DetilsCallBack() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(DetilsInfo response, int id) {

                        //设置
                        setlist(response);
                    }
                });
    }

    private void setlist(DetilsInfo response) {

        List<DetilsInfo.DataBean> dataBeen = response.getData();
        DetilsInfo.DataBean bean = dataBeen.get(0);
        //设置cb
        setCb(bean,cbDetils);
        //
        txtDetilsDesc.setText(bean.getGoodsDescription());
        //
        txtDetilsOrder.setText("定金¥ "+bean.getGoodsDepositPrice());
        //
        txtDetilsAllprice.setText("总价¥ "+bean.getGoodsStorePrice());
        //

    }



    private void initView() {

        loadWeb();
    }

    public void loadWeb() {
        //此方法可以在webview中打开链接而不会跳转到外部浏览器
        wbDetils.setWebViewClient(new WebViewClient());
        wbDetils.loadUrl(Constant.getWebUrl(goodsId));
    }

    private void setCb(DetilsInfo.DataBean bean,ConvenientBanner cb) {

        List<String> callyList = bean.getGoodsCallyList();
        List<String> imgs = new ArrayList<>();
        for (int i= 0,len= callyList.size();i<len;i++){

            imgs.add(Constant.FUWUQI_DE+callyList.get(i));
        }

        cb.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new LocalImageHolderView();
            }
        }, imgs) //imgUrls是图片地址的集合
                //设置指示器是否可见
                .setPointViewVisible(true)
                //设置两个点图片作为翻页指示器，
                // 不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.drawable.dot_normal,
                        R.drawable.dot_selected})
                //设置指示器位置（左、中、右）
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);

        //设置监听
        cb.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });
    }

    class LocalImageHolderView implements Holder<String> {

        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            //glide加载出图片，data是传过来的图片地址，
            Glide.with(context)
                    .load(data)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);
        }


    }

    @Override
    protected void onResume() {
        super.onResume();

        cbDetils.startTurning(3000);
    }

    @Override
    protected void onStop() {
        super.onStop();

        cbDetils.stopTurning();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        OkHttpUtils.getInstance().cancelTag(this);
    }
}
