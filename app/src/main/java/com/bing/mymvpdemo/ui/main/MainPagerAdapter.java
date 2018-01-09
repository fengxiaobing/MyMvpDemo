package com.bing.mymvpdemo.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.bing.mymvpdemo.ui.main.FourFragment.FourFragment;
import com.bing.mymvpdemo.ui.main.OneFragment.OneFragment;
import com.bing.mymvpdemo.ui.main.ThreeFragment.ThreeFragment;
import com.bing.mymvpdemo.ui.main.TwoFragment.TwoFragment;

/**
 * Created by RF
 * on 2018/1/9.
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    private int mTabCount;
    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
        this.mTabCount = 0;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return OneFragment.newInstance();
            case 1:
                return TwoFragment.newInstance();
            case 2:
                return ThreeFragment.newInstance();
            case 3:
                return FourFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabCount;
    }
    public void setCount(int count) {
        mTabCount = count;
    }
}
