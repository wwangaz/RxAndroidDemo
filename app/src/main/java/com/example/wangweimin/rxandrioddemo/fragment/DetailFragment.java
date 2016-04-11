package com.example.wangweimin.rxandrioddemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wangweimin.rxandrioddemo.R;
import com.example.wangweimin.rxandrioddemo.entity.Subject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wangweimin on 16/4/11.
 */
public class DetailFragment extends Fragment {
    private Subject subject;
    private final static String SUBJECT_KEY = "subject";

    @Bind(R.id.detail_fragment_img)
    ImageView mSubjectImg;

    @Bind(R.id.detail_fragment_title)
    TextView mSubjectTitle;

    @Bind(R.id.detail_fragment_summary)
    TextView mSubjectSummary;

    public static DetailFragment newInstance(Subject subject) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(SUBJECT_KEY, subject);
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(bundle);
        return detailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        subject = getArguments().getParcelable(SUBJECT_KEY);
        if (subject != null && subject.images != null) {
            Glide.with(this).load(subject.images.large).into(mSubjectImg);
            mSubjectTitle.setText(subject.title);
            mSubjectSummary.setText(subject.summary);
        }

        mSubjectImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
