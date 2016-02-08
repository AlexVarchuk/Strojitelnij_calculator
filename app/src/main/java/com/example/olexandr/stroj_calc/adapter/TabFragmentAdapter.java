package com.example.olexandr.stroj_calc.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.olexandr.stroj_calc.fragment.ConcreteFragment;
import com.example.olexandr.stroj_calc.fragment.CutFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olexandr on 24.01.16.
 */
public class TabFragmentAdapter extends FragmentStatePagerAdapter {


    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mFragmentTitles = new ArrayList<>();

    int mNumOfTabs;


    public TabFragmentAdapter(FragmentManager fm, int _numOfTabs) {
        super(fm);
        this.mNumOfTabs = _numOfTabs;


    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:{
                ConcreteFragment  concreteFragment = new ConcreteFragment();
                return concreteFragment;
            }
            case 1:{
                CutFragment cutFragment = new CutFragment();
                return  cutFragment;
            }
            default:{
                return null;
            }
        }

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
