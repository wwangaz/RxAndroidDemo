package com.example.wangweimin.rxandrioddemo.adapter;

import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.wangweimin.rxandrioddemo.R;
import com.example.wangweimin.rxandrioddemo.animate.DetailTransition;
import com.example.wangweimin.rxandrioddemo.entity.Subject;
import com.example.wangweimin.rxandrioddemo.fragment.DetailFragment;
import com.example.wangweimin.rxandrioddemo.viewholder.GridViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangweimin on 16/4/7.
 */
public class GridAdapter extends RecyclerView.Adapter<GridViewHolder> {
    private List<Subject> mDataList;
    private FragmentActivity mContext;

    public GridAdapter(FragmentActivity context) {
        mDataList = new ArrayList<>();
        mContext = context;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_fragment, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final GridViewHolder holder, int position) {
        if (position >= mDataList.size())
            return;
        final Subject subject = mDataList.get(position);
        if (subject.images != null)
            Glide.with(mContext).load(subject.images.medium).into(holder.mGridItemImg);
        holder.mGridItemImg.setTransitionName(mContext.getResources().getString(R.string.transition_name));
        holder.mGridItemTv.setText(subject.title);
        holder.mGridItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetailFragment fragment = DetailFragment.newInstance(subject);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    fragment.setSharedElementEnterTransition(new DetailTransition());
                    fragment.setExitTransition(new Fade());
                    fragment.setEnterTransition(new Fade());
                    fragment.setSharedElementReturnTransition(new DetailTransition());
                }

                mContext.getSupportFragmentManager().beginTransaction()
                        .addSharedElement(holder.mGridItemImg, mContext.getResources().getString(R.string.transition_name))
                        .replace(R.id.main_content_view, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    public void addData(List<Subject> addList) {
        mDataList.addAll(addList);
        notifyDataSetChanged();
    }

    public void replaceData(List<Subject> replaceList) {
        if (replaceList != null) {
            mDataList = replaceList;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }
}
