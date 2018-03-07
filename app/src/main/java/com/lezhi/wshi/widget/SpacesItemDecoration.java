package com.lezhi.wshi.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by 王二星
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration{

    private int space;
    private boolean left_right = false;

    public SpacesItemDecoration(int space,boolean isOpenL_R) {
        this.space = space;
        this.left_right = isOpenL_R;
    }
    // 设置itemView中内容相对边框左，上，右，下距离
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        outRect.bottom = space;
        outRect.top = space;

        if(left_right){
            outRect.left = space;
            outRect.right = space;
        }
    }
}