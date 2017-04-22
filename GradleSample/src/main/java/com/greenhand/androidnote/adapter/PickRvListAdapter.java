package com.greenhand.androidnote.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
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
 * time: 2017/4/21 01:47
 * e-mail:13967189624@163.com
 * description:
 */

public class PickRvListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Flowers.DataBean.GoodsListBean> list;
    private Context mContext;
    private LayoutInflater inflater;

    public PickRvListAdapter(List<Flowers.DataBean.GoodsListBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_common, parent, false);
        return new PickHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        PickHolder pickHolder = (PickHolder) holder;
        final Flowers.DataBean.GoodsListBean listBean = list.get(position);
        pickHolder.txtDesc.setText(listBean.getGoodsName());
        pickHolder.txtPrice.setText("¥" + listBean.getGoodsStorePrice());
        Glide.with(mContext)
                .load(Constant.FUWUQI_DE + listBean.getGoodsImage())
                .into(pickHolder.imgContent);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int goodsId = listBean.getGoodsId();
                goDetils(String.valueOf(goodsId));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PickHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_content)
        ImageView imgContent;
        @BindView(R.id.txt_desc)
        TextView txtDesc;
        @BindView(R.id.txt_price)
        TextView txtPrice;

        public PickHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    private void goDetils(String id){

        Intent intent = new Intent(mContext, DetilsActivity.class);
        intent.putExtra("goodsId",id);
        MainActivity activity = (MainActivity) mContext;
        activity.startActivity(intent);
    }
}
