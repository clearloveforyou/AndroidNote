package com.greenhand.androidnote.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.greenhand.androidnote.R;
import com.greenhand.androidnote.info.TabBean;
import com.greenhand.androidnote.utils.Constant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * project: AndroidNote
 * package: com.greenhand.androidnote.adapter
 * author: HouShengLi
 * time: 2017/4/21 01:01
 * e-mail:13967189624@163.com
 * description:
 */

public class TabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<TabBean.DataBean> dataBeen;
    private LayoutInflater inflater;

    public TabAdapter(List<TabBean.DataBean> dataBeen, Context mContext) {
        this.dataBeen = dataBeen;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
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
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(tabHolder.img);

        tabHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击事件
                Toast.makeText(mContext, "" + position, Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return dataBeen.size();
    }

    class TabHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_item_tab)
        ImageView img;
        @BindView(R.id.txt_item_title)
        TextView txt;

        public TabHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
