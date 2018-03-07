package com.lezhi.wshi.module.ui.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lezhi.wshi.R;
import com.lezhi.wshi.module.entity.Prodata;
import com.lezhi.wshi.utils.EventUtil;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Prodata> products;
    private Context mContext;

    private static RecycleItemClickListener clickListener;

    public static final int ONE_ITEM = 1;
    public static final int TWO_ITEM = 2;

    public NewsAdapter(Context context, List<Prodata> list, RecycleItemClickListener clickListener) {
        mContext = context;
        products = list;
        this.clickListener = clickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        RecyclerView.ViewHolder holder = null;
        if(ONE_ITEM == viewType){
            View v = mInflater.inflate(R.layout.item_news,viewGroup,false);
            holder = new MasonrynormalView(v);
        }else{
            View v = mInflater.inflate(R.layout.item_news_big,viewGroup,false);
            holder = new MasonryBigView(v);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MasonrynormalView){
            ((MasonrynormalView) holder).tv_title.setText(products.get(position).getTitle());
            ((MasonrynormalView) holder).tv_date.setText(products.get(position).getDay()+" / "+products.get(position).getMonth());
            ((MasonrynormalView) holder).tv_laiyuan.setText(products.get(position).getLy());
            ((MasonrynormalView) holder).iv_picture.setImageResource(products.get(position).getPID());
        }else {
            ((MasonryBigView) holder).tv_big_title.setText(products.get(position).getTitle());
            ((MasonryBigView) holder).tv_big_date.setText(products.get(position).getDay()+" / "+products.get(position).getMonth());
            ((MasonryBigView) holder).tv_big_laiyuan.setText(products.get(position).getLy());
            ((MasonryBigView) holder).iv_big_picture.setImageResource(products.get(position).getPID());
        }
    }


    @Override
    public int getItemCount() {
        return products.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position % 5 == 4){
            return TWO_ITEM;
        }else{
            return ONE_ITEM;
        }
    }

    class MasonrynormalView extends  RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tv_title,tv_laiyuan,tv_date;
        private ImageView iv_picture;

        public MasonrynormalView(View itemView){
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.news_title);
            tv_laiyuan = (TextView) itemView.findViewById(R.id.news_laiyuan);
            tv_date = (TextView) itemView.findViewById(R.id.news_date);
            iv_picture = (ImageView) itemView.findViewById(R.id.news_picture);
            iv_picture.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(view,this.getLayoutPosition());
        }
    }

    class MasonryBigView extends  RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView tv_big_title,tv_big_laiyuan,tv_big_date;
        private ImageView iv_big_picture;
        public MasonryBigView(View itemView) {
            super(itemView);
            tv_big_title = (TextView) itemView.findViewById(R.id.news_big_title);
            tv_big_laiyuan = (TextView) itemView.findViewById(R.id.news_big_laiyuan);
            tv_big_date = (TextView) itemView.findViewById(R.id.news_big_date);
            iv_big_picture = (ImageView) itemView.findViewById(R.id.news_big_picture);
            iv_big_picture.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(view,this.getLayoutPosition());
        }
    }
}
