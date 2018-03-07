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
import com.lezhi.wshi.module.entity.TecherEntity;

import java.util.List;

public class TecherSayAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<TecherEntity> products;
    private Context mContext;

    public static final int ONE_ITEM = 1;
    public static final int TWO_ITEM = 2;

    public TecherSayAdapter(Context context, List<TecherEntity> list) {
        mContext = context;
        products = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        RecyclerView.ViewHolder holder = null;
        if(ONE_ITEM == viewType){
            View v = mInflater.inflate(R.layout.item_tacher_say,viewGroup,false);
            holder = new MasonrynormalView(v);
        }else{
            View v = mInflater.inflate(R.layout.item_tacher_say_txt,viewGroup,false);
            holder = new MasonryTextView(v);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MasonrynormalView){
            ((MasonrynormalView) holder).tv_title.setText(products.get(position).getTitle());
            ((MasonrynormalView) holder).tv_name.setText(products.get(position).getUserName());
            ((MasonrynormalView) holder).tv_laiyuan.setText(products.get(position).getZy());
            ((MasonrynormalView) holder).iv_picture.setImageResource(R.mipmap.ic_launcher);
        }else {
            ((MasonryTextView) holder).tv_text_title.setText(products.get(position).getTitle());
            ((MasonryTextView) holder).tv_text_name.setText(products.get(position).getUserName());
            ((MasonryTextView) holder).tv_text_laiyuan.setText(products.get(position).getZy());
        }
    }


    @Override
    public int getItemCount() {
        return products.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position % 2 == 1){
            return TWO_ITEM;
        }else{
            return ONE_ITEM;
        }
    }

    class MasonrynormalView extends  RecyclerView.ViewHolder {

        private TextView tv_title,tv_laiyuan,tv_name;
        private ImageView iv_picture;

        public MasonrynormalView(View itemView){
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.techer_title);
            tv_laiyuan = (TextView) itemView.findViewById(R.id.techer_laiyuan);
            tv_name = (TextView) itemView.findViewById(R.id.techer_name);
            iv_picture = (ImageView) itemView.findViewById(R.id.techer_picture);
        }
    }

    class MasonryTextView extends  RecyclerView.ViewHolder {

        private TextView tv_text_title,tv_text_laiyuan,tv_text_name;

        public MasonryTextView(View itemView) {
            super(itemView);
            tv_text_title = (TextView) itemView.findViewById(R.id.techer_text_title);
            tv_text_laiyuan = (TextView) itemView.findViewById(R.id.techer_text_laiyuan);
            tv_text_name = (TextView) itemView.findViewById(R.id.techer_text_name);
        }
    }
}
