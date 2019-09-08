package com.bbva.face.presentation.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.bbva.face.R;
import com.bbva.face.data.external.EnrollService;
import com.bbva.face.presentation.fragments.DescriptionContainerFragment;
import com.bbva.face.presentation.fragments.WebCameraFragment;

public class EnrollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll);
        getWindow().setStatusBarColor(0);
        initViews();
        initListeners();
        initAdapters();
        initValues();
    }

    private void initViews() {
        new EnrollService(this).callService("AAAAAA", "BBBBBB");
    }

    private void initListeners() {
    }

    private void initAdapters() {
    }

    private void initValues() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.flEnroll, DescriptionContainerFragment.newInstance(), "DescriptionContainerFragment");
        fragmentTransaction.commit();
    }

    public void changeFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(getSupportFragmentManager().findFragmentByTag("DescriptionContainerFragment"));
        fragmentTransaction.replace(R.id.flEnroll, WebCameraFragment.newInstance(), "WebCameraFragment");
        fragmentTransaction.commit();
    }

}
