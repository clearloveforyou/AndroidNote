package com.greenhand.androidnote;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bumptech.glide.Glide;

import java.util.List;

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

    public RecyclerView rvPick;
    public ConvenientBanner cb;
    public RecyclerView rvTab;
    public GridView gvNew;

    private List<String> imgUrls;
    private List<TabBean.DataBean> tabBeanList;
    private List<Flowers.DataBean> flowersList;
    private LayoutInflater inflater;
    private Context mContext;

    public HomeRvAdapter(List<String> imgUrls, List<TabBean.DataBean> tabBeanList, List<Flowers.DataBean> flowersList, Context mContext) {
        this.imgUrls = imgUrls;
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

            setCb();
        } else if (holder instanceof TabVH) {

            rvTab.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            TabAdapter tabAdapter = new TabAdapter(tabBeanList);
            rvTab.setAdapter(tabAdapter);

        } else if (holder instanceof NewVH) {

            Flowers.DataBean dataBean = flowersList.get(position-2);
            NewVH newVH = (NewVH) holder;
            newVH.txt.setText(dataBean.getFloorName());
            Glide.with(mContext)
                    .load(Constant.FUWUQI_DE + dataBean.getBannerIcon())
                    .into(newVH.imgBanner);

            String img = dataBean.getBannerImg();
            if (img.equals("")) {
                newVH.imgHead.setVisibility(View.GONE);
            } else {
                Glide.with(mContext)
                        .load(Constant.FUWUQI_DE + dataBean.getBannerImg())
                        .into(newVH.imgHead);
            }
            List<Flowers.DataBean.GoodsListBean> goodsList = dataBean.getGoodsList();
            ItemGdAdapter gdAdapter = new ItemGdAdapter(goodsList);

            gvNew.setAdapter(gdAdapter);

            gvNew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(mContext, ""+position, Toast.LENGTH_SHORT).show();
                }
            });


        } else if (holder instanceof PickVH) {

            Flowers.DataBean dataBean = flowersList.get(position-2);
            PickVH pickVH = (PickVH) holder;

            pickVH.txtBanner.setText(dataBean.getFloorName());
            Glide.with(mContext)
                    .load(Constant.FUWUQI_DE + dataBean.getBannerIcon())
                    .into(pickVH.imgBanner);
            String bannerImg = dataBean.getBannerImg();
            if (bannerImg.equals("")) {

                pickVH.imgHead.setVisibility(View.GONE);
            } else {

                Glide.with(mContext)
                        .load(Constant.FUWUQI_DE + dataBean.getBannerImg())
                        .into(pickVH.imgHead);
            }

            rvPick.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            PickAdapter pickAdapter = new PickAdapter(dataBean.getGoodsList());
            rvPick.setAdapter(pickAdapter);
        }

    }

    class PickAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        public PickAdapter(List<Flowers.DataBean.GoodsListBean> list) {
            this.list = list;
        }

        List<Flowers.DataBean.GoodsListBean> list;

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = inflater.inflate(R.layout.item_common, parent, false);
            return new PickHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

            PickHolder pickHolder = (PickHolder) holder;
            Flowers.DataBean.GoodsListBean listBean = list.get(position);
            pickHolder.txtDesc.setText(listBean.getGoodsName());
            pickHolder.txtPrice.setText("¥" + listBean.getGoodsStorePrice());
            Glide.with(mContext)
                    .load(Constant.FUWUQI_DE + listBean.getGoodsImage())
                    .into(pickHolder.imgContent);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(mContext, ""+position, Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class PickHolder extends RecyclerView.ViewHolder {


            ImageView imgContent;
            TextView txtDesc;
            TextView txtPrice;

            public PickHolder(View view) {
                super(view);
                imgContent = (ImageView) view.findViewById(R.id.img_content);
                txtDesc = (TextView) view.findViewById(R.id.txt_desc);
                txtPrice = (TextView) view.findViewById(R.id.txt_price);
            }
        }
    }

    private void setCb() {

        cb.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new LocalImageHolderView();
            }
        }, imgUrls) //imgUrls是图片地址的集合
                .setPointViewVisible(true)    //设置指示器是否可见
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.drawable.comment_star_empty_mid, R.drawable.comment_star_mid})
                //设置指示器位置（左、中、右）
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .startTurning(3000);

        cb.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(mContext, ""+position, Toast.LENGTH_SHORT).show();
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
            Glide.with(context).load(data).into(imageView);
        }


    }

    class ItemGdAdapter extends BaseAdapter {

        private List<Flowers.DataBean.GoodsListBean> goodsLists;

        public ItemGdAdapter(List<Flowers.DataBean.GoodsListBean> goodsLists) {
            this.goodsLists = goodsLists;
        }

        @Override
        public int getCount() {
            return goodsLists.size();
        }

        @Override
        public Object getItem(int position) {
            return goodsLists.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            VH vh;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.item_common, parent, false);
                vh = new VH(convertView);
                convertView.setTag(vh);
            } else {
                vh = (VH) convertView.getTag();
                Flowers.DataBean.GoodsListBean listBean = goodsLists.get(position);
                vh.txtDesc.setText(listBean.getGoodsName());
                vh.txtPrice.setText("¥" + listBean.getGoodsStorePrice());
                Glide.with(mContext)
                        .load(Constant.FUWUQI_DE + listBean.getGoodsImage())
                        .skipMemoryCache(false)
                        .into(vh.imgContent);

            }
            return convertView;
        }

        public class VH {

            ImageView imgContent;
            TextView txtDesc;
            TextView txtPrice;

            public VH(View view) {
                imgContent = (ImageView) view.findViewById(R.id.img_content);
                txtDesc = (TextView) view.findViewById(R.id.txt_desc);
                txtPrice = (TextView) view.findViewById(R.id.txt_price);
            }
        }
    }

    class TabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<TabBean.DataBean> dataBeen;

        public TabAdapter(List<TabBean.DataBean> dataBeen) {
            this.dataBeen = dataBeen;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = inflater.inflate(R.layout.item_tab_child, parent, false);
            return new TabHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {


            TabHolder tabHolder = (TabHolder) holder;
            TabBean.DataBean bean = dataBeen.get(position);

            tabHolder.txt.setText(bean.getMenuName());
            Glide.with(mContext)
                    .load(Constant.FUWUQI_DE + bean.getMenuPic())
                    .into(tabHolder.img);

            tabHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //点击事件
                    Toast.makeText(mContext, ""+position, Toast.LENGTH_SHORT).show();
                }
            });


        }

        @Override
        public int getItemCount() {
            return dataBeen.size();
        }

        class TabHolder extends RecyclerView.ViewHolder {

            ImageView img;
            TextView txt;

            public TabHolder(View itemView) {
                super(itemView);

                img = (ImageView) itemView.findViewById(R.id.img_item_tab);
                txt = (TextView) itemView.findViewById(R.id.txt_item_title);

            }
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

        public CbVH(View itemView) {
            super(itemView);
            cb = (ConvenientBanner) itemView.findViewById(R.id.cb);
        }
    }


    //TAB
    class TabVH extends RecyclerView.ViewHolder {


        public TabVH(View itemView) {
            super(itemView);
            rvTab = (RecyclerView) itemView.findViewById(R.id.rv_tab);
        }
    }

    //新品推荐
    class NewVH extends RecyclerView.ViewHolder {

        ImageView imgHead;
        TextView txt;
        ImageView imgBanner;

        public NewVH(View itemView) {
            super(itemView);
            imgHead = (ImageView) itemView.findViewById(R.id.img_head2);
            txt = (TextView) itemView.findViewById(R.id.txt_banner2);
            imgBanner = (ImageView) itemView.findViewById(R.id.img_banner2);
            gvNew = (GridView) itemView.findViewById(R.id.gv_item_new);
        }
    }


    //现货优选
    class PickVH extends RecyclerView.ViewHolder {

        ImageView imgHead;
        TextView txtBanner;
        ImageView imgBanner;

        public PickVH(View itemView) {
            super(itemView);
            imgHead = (ImageView) itemView.findViewById(R.id.img_head);
            txtBanner = (TextView) itemView.findViewById(R.id.txt_banner);
            imgBanner = (ImageView) itemView.findViewById(R.id.img_banner);
            rvPick = (RecyclerView) itemView.findViewById(R.id.rv_pick);
        }
    }


}
