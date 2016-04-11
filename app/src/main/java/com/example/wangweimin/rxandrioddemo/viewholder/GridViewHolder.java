package com.example.wangweimin.rxandrioddemo.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wangweimin.rxandrioddemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wangweimin on 16/4/7.
 */
public class GridViewHolder extends RecyclerView.ViewHolder{
    @Bind(R.id.item_grid_fragment_layout)
    public RelativeLayout mGridItemLayout;

    @Bind(R.id.item_grid_fragment_img)
    public ImageView mGridItemImg;

    @Bind(R.id.item_grid_fragment_tv)
    public TextView mGridItemTv;

    public GridViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
