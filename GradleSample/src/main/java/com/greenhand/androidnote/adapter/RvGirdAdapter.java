package com.greenhand.androidnote.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.greenhand.androidnote.DetilsActivity;
import com.greenhand.androidnote.MainActivity;
import com.greenhand.androidnote.R;
import com.greenhand.androidnote.info.Flowers;
import com.greenhand.androidnote.utils.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * project: AndroidNote
 * package: com.greenhand.androidnote.adapter
 * author: HouShengLi
 * time: 2017/4/21 01:27
 * e-mail:13967189624@163.com
 * description:
 */

public class RvGirdAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Flowers.DataBean.GoodsListBean> goodsLists;
    private Context mContext;
    private LayoutInflater inflater;

    public RvGirdAdapter(List<Flowers.DataBean.GoodsListBean> goodsLists, Context mContext) {
        this.goodsLists = goodsLists;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_common, parent, false);
        return new Vh(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Vh vh = (Vh) holder;
        final Flowers.DataBean.GoodsListBean listBean = goodsLists.get(position);
        vh.txtDesc.setText(listBean.getGoodsName());
        vh.txtPrice.setText("¥" + listBean.getGoodsStorePrice());
        Glide.with(mContext)
                .load(Constant.FUWUQI_DE + listBean.getGoodsImage())
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(vh.imgContent);

        //
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goDetils(String.valueOf(listBean.getGoodsId()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return goodsLists != null ? goodsLists.size() : 0;
    }


    class Vh extends RecyclerView.ViewHolder {

        @BindView(R.id.img_content)
        ImageView imgContent;
        @BindView(R.id.txt_desc)
        TextView txtDesc;
        @BindView(R.id.txt_price)
        TextView txtPrice;

        public Vh(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

    private void goDetils(String id){

        Intent intent = new Intent(mContext, DetilsActivity.class);
        intent.putExtra("goodsId",id);
        MainActivity activity = (MainActivity) mContext;
        activity.startActivity(intent);
    }
}
