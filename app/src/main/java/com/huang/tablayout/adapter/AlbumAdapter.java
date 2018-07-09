package com.huang.tablayout.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * File description.
 *
 * @author 黄汝琪
 * @date 2018/6/14
 */
public class AlbumAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList;

    public AlbumAdapter(FragmentManager fm,ArrayList<Fragment> mFragmentList) {
        super(fm);
        this.mFragmentList = mFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = mFragmentList.get(position);

        return fragment;
    }

    @Override
    public int getCount() {
        int size = mFragmentList.size();
        return mFragmentList.size();
    }
}
