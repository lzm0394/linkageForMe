package com.lzm.meandmybreakheart.fragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by luzhiming on 2017/3/9.
 */

public class MeAdapter extends FragmentPagerAdapter {
    List<Fragment> fragments;
    List<String> words;

    public MeAdapter(FragmentManager fm, List<Fragment> fragments, List<String> words) {
        super(fm);
        this.fragments = fragments;
        this.words = words;
    }

    @Override
    public Fragment getItem(int position) {

        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return words.get(position);
    }
}
