package com.bbva.face.presentation.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bbva.face.R;
import com.bbva.face.presentation.activities.EnrollActivity;
import com.bbva.face.presentation.adapters.DescriptionPagerAdapter;

public class DescriptionContainerFragment extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private ImageView ivLeft, ivRight;
    private TextView tvSkip;
    private ViewPager vpDescription;
    private DescriptionPagerAdapter descriptionPagerAdapter;
    private int position;

    public DescriptionContainerFragment() {
        // Required empty public constructor
    }

    public static DescriptionContainerFragment newInstance() {
        DescriptionContainerFragment fragment = new DescriptionContainerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_description_container, container, false);

        initPresenter();
        initViews(root);
        initAdapters();
        initListeners();
        initValues();

        return root;
    }


    private void initPresenter() {
    }

    private void initViews(View root) {
        vpDescription = root.findViewById(R.id.vpDescription);
        ivLeft = root.findViewById(R.id.ivLeft);
        ivRight = root.findViewById(R.id.ivRight);
        tvSkip = root.findViewById(R.id.tvSkip);
    }

    private void initAdapters() {
        descriptionPagerAdapter = new DescriptionPagerAdapter(getChildFragmentManager());
        vpDescription.setAdapter(descriptionPagerAdapter);

    }

    private void initListeners() {
        vpDescription.addOnPageChangeListener(this);
        tvSkip.setOnClickListener(this);
        ivLeft.setOnClickListener(this);
        ivRight.setOnClickListener(this);
    }

    private void initValues() {
        onPageSelected(0);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
            ivLeft.setVisibility(View.GONE);
            ivRight.setVisibility(View.VISIBLE);
            tvSkip.setVisibility(View.VISIBLE);
            ivRight.setTag("next");
            ivRight.setImageDrawable(getResources().getDrawable(R.drawable.ic_next));
        } else if (position == descriptionPagerAdapter.getCount() - 1) {
            ivLeft.setVisibility(View.VISIBLE);
            ivRight.setVisibility(View.VISIBLE);
            tvSkip.setVisibility(View.GONE);
            ivRight.setImageDrawable(getResources().getDrawable(R.drawable.ic_done));
            ivRight.setTag("finish");
        } else {
            ivLeft.setVisibility(View.VISIBLE);
            ivRight.setVisibility(View.VISIBLE);
            tvSkip.setVisibility(View.VISIBLE);
            ivRight.setImageDrawable(getResources().getDrawable(R.drawable.ic_next));
            ivRight.setTag("next");
        }

        this.position = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvSkip:
                ((EnrollActivity) getActivity()).changeFragment();
                break;
            case R.id.ivLeft:
                vpDescription.setCurrentItem(position - 1);
                break;
            case R.id.ivRight:
                if (ivRight.getTag().equals("next")) {
                    vpDescription.setCurrentItem(position + 1);
                } else {
                    ((EnrollActivity) getActivity()).changeFragment();
                }
                break;
        }
    }
}
