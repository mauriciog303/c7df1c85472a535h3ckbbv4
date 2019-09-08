package com.bbva.face.presentation.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bbva.face.R;

public class DescriptionFragment extends Fragment {

    private ImageView ivIcon;
    private TextView tvDescription;
    private String description;
    private int idIcon;

    public DescriptionFragment() {
    }

    public static DescriptionFragment newInstance(int idIcon, String description) {
        DescriptionFragment fragment = new DescriptionFragment();
        Bundle args = new Bundle();
        args.putInt("idIcon", idIcon);
        args.putString("description", description);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            description = getArguments().getString("description");
            idIcon = getArguments().getInt("idIcon");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_description, container, false);
        initPresenter();
        initViews(root);
        initListeners();
        initAdapters();
        initValues();
        return root;
    }

    private void initPresenter() {
    }

    private void initViews(View root) {
        ivIcon = root.findViewById(R.id.ivIcon);
        tvDescription = root.findViewById(R.id.tvDescription);
    }

    private void initListeners() {
    }

    private void initAdapters() {
    }

    private void initValues() {
        tvDescription.setText(description);
        ivIcon.setImageDrawable(getResources().getDrawable(idIcon));
    }


}
