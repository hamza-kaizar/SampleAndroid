package com.example.sample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class ViewAdapter extends FragmentStateAdapter {
    int tabs = 3;
    Bundle appInfo;

    public ViewAdapter(FragmentManager supportFragmentManager, Lifecycle lifecycle, Bundle appInfo) {
        super(supportFragmentManager, lifecycle);
        this.appInfo = appInfo;
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return appFragment("all");
            case 1:
                return appFragment("system");
            case 2:
                return appFragment("user");
            default:
                return new Fragment();
        }
    }

    public AllAppsFragment appFragment(String key) {
        AllAppsFragment fragment = new AllAppsFragment();
        Bundle args = new Bundle();
        ArrayList<String> appInfo = this.appInfo.getStringArrayList(key);
        args.putStringArrayList("appInfo", appInfo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return tabs;
    }
}