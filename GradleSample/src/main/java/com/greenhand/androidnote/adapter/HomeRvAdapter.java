package com.greenhand.androidnote.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.greenhand.androidnote.DetilsActivity;
import com.greenhand.androidnote.MainActivity;
import com.greenhand.androidnote.R;
import com.greenhand.androidnote.info.AdsBanner;
import com.greenhand.androidnote.info.Flowers;
import com.greenhand.androidnote.info.TabBean;
import com.greenhand.androidnote.utils.Constant;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * project: AndroidNote
 * package: com.greenhand.androidnote
 * author: HouShengLi
 * time: 2017/4/18 11:37
 * e-mail:13967189624@163.com
 * description:
 */

public class HomeRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    /**
     * RecycleViewAdapter 要素点：
     * <p/>
     * 1，ViewHolder必须继承RecyclerView.ViewHolder
     * 2，RecycleView.Adapter的泛型为自定义ViewHolder
     */

    public static final int TYPE_ADS_BANNER = 0;//头部广告
    public static final int TYPE_FOUR = 1;//新品 手办 现货 热卖
    public static final int TYPE_NEW = 2;//新品推荐\手办预定
    public static final int TYPE_CHOOSR = 3;//现货优选\其他


    private List<AdsBanner.DataBean.AdvListBean> advListBeen;
    private List<TabBean.DataBean> tabBeanList;
    private List<Flowers.DataBean> flowersList;
    private LayoutInflater inflater;
    private Context mContext;

    public HomeRvAdapter(List<AdsBanner.DataBean.AdvListBean> imgUrls, List<TabBean.DataBean> tabBeanList, List<Flowers.DataBean> flowersList, Context mContext) {
        this.advListBeen = imgUrls;
        this.tabBeanList = tabBeanList;
        this.flowersList = flowersList;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ADS_BANNER) {

            View view = inflater.inflate(R.layout.item_banner, parent, false);
            return new CbVH(view);
        } else if (viewType == TYPE_FOUR) {
            //
            View view = inflater.inflate(R.layout.item_tab, parent, false);
            return new TabVH(view);

        } else if (viewType == TYPE_NEW) {

            //
            View view = inflater.inflate(R.layout.item_new, parent, false);
            return new NewVH(view);

        } else if (viewType == TYPE_CHOOSR) {
            //
            View view = inflater.inflate(R.layout.item_pick, parent, false);
            return new PickVH(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof CbVH) {

            CbVH cbVH = (CbVH) holder;
            setCb(cbVH.cb);
        } else if (holder instanceof TabVH) {

            TabVH tabVH = (TabVH) holder;
            tabVH.rvTab.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            TabAdapter tabAdapter = new TabAdapter(tabBeanList, mContext);
            tabVH.rvTab.setAdapter(tabAdapter);

        } else if (holder instanceof NewVH) {

            //获取数据的真是位置
            int rel = position - 2;
            Flowers.DataBean dataBean = flowersList.get(rel);
            NewVH newVH = (NewVH) holder;

            newVH.txt.setText(dataBean.getFloorName());
            Glide.with(mContext)
                    .load(Constant.FUWUQI_DE + dataBean.getBannerIcon())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(newVH.imgBanner);

            String img = dataBean.getBannerImg();
            if (img.equals("")) {
                newVH.imgHead.setVisibility(View.GONE);
            } else {
                Glide.with(mContext)
                        .load(Constant.FUWUQI_DE + dataBean.getBannerImg())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(newVH.imgHead);
            }
            List<Flowers.DataBean.GoodsListBean> goodsList = dataBean.getGoodsList();

            //
            newVH.rvGrid.setLayoutManager(new GridLayoutManager(mContext, 3));
            //水平分割
            newVH.rvGrid.addItemDecoration(
                    new HorizontalDividerItemDecoration.Builder(mContext)
                            .color(Color.parseColor("#f5f0f0"))
                            .size(15)
                            .build());
//            //垂直分割
//            newVH.rvGrid.addItemDecoration(
//                    new VerticalDividerItemDecoration.Builder(mContext)
//                            .color(Color.parseColor("#f5f0f0"))
//                            .size(15)
//                            .build());
            RvGirdAdapter girdAdapter = new RvGirdAdapter(goodsList, mContext);
            newVH.rvGrid.setAdapter(girdAdapter);

        } else if (holder instanceof PickVH) {

            final Flowers.DataBean dataBean = flowersList.get(position - 2);
            PickVH pickVH = (PickVH) holder;

            pickVH.txtBanner.setText(dataBean.getFloorName());
            Glide.with(mContext)
                    .load(Constant.FUWUQI_DE + dataBean.getBannerIcon())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(pickVH.imgBanner);
            String bannerImg = dataBean.getBannerImg();
            if (bannerImg.equals("")) {

                pickVH.imgHead.setVisibility(View.GONE);
            } else {

                Glide.with(mContext)
                        .load(Constant.FUWUQI_DE + dataBean.getBannerImg())
                        .into(pickVH.imgHead);

                //给图片监听
                pickVH.imgHead.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goDetils(dataBean.getBannerImgOptContent());
                    }
                });
            }

            pickVH.rvPick.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            PickRvListAdapter adapter = new PickRvListAdapter(dataBean.getGoodsList(), mContext);
            pickVH.rvPick.setAdapter(adapter);
        }

    }


    private void setCb(ConvenientBanner cb) {

        List<String> imgs = new ArrayList<>();
        final List<String> ids = new ArrayList<>();
        for (int i = 0,len = advListBeen.size();i<len;i++){
            AdsBanner.DataBean.AdvListBean bean = advListBeen.get(i);
            imgs.add(Constant.FUWUQI_DE+bean.getResUrl());
            ids.add(bean.getOperationContent());
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
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                //开始滚动  每3秒
                .startTurning(3000);

        //设置监听
        cb.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                goDetils(ids.get(position));
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
    public int getItemCount() {

        return flowersList.size() + 2;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {

            return TYPE_ADS_BANNER;
        } else if (position == 1) {

            return TYPE_FOUR;
        } else if (position == 2 || position == 3) {

            return TYPE_NEW;
        } else {
            return TYPE_CHOOSR;
        }
    }

    //广告栏
    class CbVH extends RecyclerView.ViewHolder {

        @BindView(R.id.cb)
        ConvenientBanner cb;

        public CbVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    //分类入口
    class TabVH extends RecyclerView.ViewHolder {

        @BindView(R.id.rv_tab)
        RecyclerView rvTab;

        public TabVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    //新品推荐
    class NewVH extends RecyclerView.ViewHolder {

        @BindView(R.id.img_head2)
        ImageView imgHead;
        @BindView(R.id.txt_banner2)
        TextView txt;
        @BindView(R.id.img_banner2)
        ImageView imgBanner;
        @BindView(R.id.rv_new)
        RecyclerView rvGrid;

        public NewVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    //现货优选
    class PickVH extends RecyclerView.ViewHolder {

        @BindView(R.id.img_head)
        ImageView imgHead;
        @BindView(R.id.txt_banner)
        TextView txtBanner;
        @BindView(R.id.img_banner)
        ImageView imgBanner;
        @BindView(R.id.rv_pick)
        RecyclerView rvPick;

        public PickVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    private void goDetils(String id){

        Intent intent = new Intent(mContext, DetilsActivity.class);
        intent.putExtra("goodsId",id);
        MainActivity activity = (MainActivity) mContext;
        activity.startActivity(intent);
    }
}
