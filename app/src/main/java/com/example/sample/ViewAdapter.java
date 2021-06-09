package com.example.sample;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

class ViewAdapter extends FragmentStateAdapter {
    int tabs = 3;

    public ViewAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new AllAppsFragment();
            case 1:
                return new SystemAppsFragment();
            case 2:
                return new UserAppsFragment();
            default:
                return new Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return tabs;
    }
}