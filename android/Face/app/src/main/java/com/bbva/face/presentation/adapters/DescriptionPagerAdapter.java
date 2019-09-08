package com.bbva.face.presentation.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.bbva.face.R;
import com.bbva.face.presentation.fragments.DescriptionFragment;

import java.util.ArrayList;
import java.util.List;

public class DescriptionPagerAdapter extends FragmentPagerAdapter {

    private List<DescriptionFragment> descriptionFragmentList;

    public DescriptionPagerAdapter(FragmentManager fm) {
        super(fm);
        descriptionFragmentList = new ArrayList<>();
        descriptionFragmentList.add(DescriptionFragment.newInstance(R.drawable.favorite, "Descubre la nueva experiencia"));
        descriptionFragmentList.add(DescriptionFragment.newInstance(R.drawable.face_id, "Entra a tus cuentas de un solo vistazo"));
        descriptionFragmentList.add(DescriptionFragment.newInstance(R.drawable.mobile_cash_dollar, "Lo unico que necesitas es observar"));
    }

    @Override
    public Fragment getItem(int position) {
        return descriptionFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return descriptionFragmentList.size();
    }

}
