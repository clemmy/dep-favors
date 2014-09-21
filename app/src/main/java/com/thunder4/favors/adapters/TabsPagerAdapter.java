package com.thunder4.favors.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.thunder4.favors.fragments.NegotiationFragment;
import com.thunder4.favors.fragments.NotificationFragment;
import com.thunder4.favors.fragments.PostFragment;
import com.thunder4.favors.fragments.ProfileFragment;

/**
 * Created by raywan on 2014-09-20.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new PostFragment();
            case 1:
                return new NegotiationFragment();
            case 2:
                //return new NotificationFragment();
            case 3:
                return new ProfileFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
