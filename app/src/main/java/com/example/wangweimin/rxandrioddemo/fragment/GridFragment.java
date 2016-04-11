package com.example.wangweimin.rxandrioddemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wangweimin.rxandrioddemo.R;
import com.example.wangweimin.rxandrioddemo.adapter.GridAdapter;
import com.example.wangweimin.rxandrioddemo.entity.Subject;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wangweimin on 16/4/7.
 */
public class GridFragment extends Fragment {
    private List<Subject> subjects;

    private GridAdapter mAdapter;

    @Bind(R.id.grid_rv_recycler)
    RecyclerView mRvRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            subjects = bundle.getParcelableArrayList("subjects");
            mAdapter = new GridAdapter(getActivity());

            mRvRecyclerView.setAdapter(mAdapter);

            mRvRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

            mAdapter.addData(subjects);
        }

    }
}
