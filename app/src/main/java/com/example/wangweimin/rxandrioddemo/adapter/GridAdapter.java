package com.example.wangweimin.rxandrioddemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.wangweimin.rxandrioddemo.R;
import com.example.wangweimin.rxandrioddemo.entity.Subject;
import com.example.wangweimin.rxandrioddemo.viewholder.GridViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangweimin on 16/4/7.
 */
public class GridAdapter extends RecyclerView.Adapter<GridViewHolder> {
    private List<Subject> mDataList;
    private Context mContext;

    public GridAdapter(Context context){
        mDataList = new ArrayList<>();
        mContext = context;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_fragment, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        if (position >= mDataList.size())
            return;
        Subject subject = mDataList.get(position);
        if (subject.images != null)
            Glide.with(mContext).load(subject.images.medium).into(holder.mGridItemImg);
        holder.mGridItemTv.setText(subject.title);
    }

    public void addData(List<Subject> addList) {
        mDataList.addAll(addList);
        notifyDataSetChanged();
    }

    public void replaceData(List<Subject> replaceList) {
        if (replaceList != null){
            mDataList = replaceList;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
