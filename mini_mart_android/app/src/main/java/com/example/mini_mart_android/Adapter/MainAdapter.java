package com.example.mini_mart_android.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mini_mart_android.Fragment.AccountFragment;
import com.example.mini_mart_android.Fragment.CartFragment;
import com.example.mini_mart_android.Fragment.CategoryFragment;
import com.example.mini_mart_android.Fragment.ProductFragment;

public class MainAdapter extends FragmentStateAdapter {
    private static final int NUM_PAGES = 3;

    public MainAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new CategoryFragment();
            case 1:
                return new CartFragment();
            case 2:
                return new AccountFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}