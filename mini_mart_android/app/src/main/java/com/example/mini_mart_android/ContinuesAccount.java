package com.example.mini_mart_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mini_mart_android.Adapter.MainAdapter;
import com.example.mini_mart_android.databinding.ActivityContinuesAccountBinding;
import com.example.mini_mart_android.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ContinuesAccount extends AppCompatActivity {

    private ActivityContinuesAccountBinding binding;
    private ViewPager2 viewPager;
    private ImageView btn_back;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContinuesAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewPager = findViewById(R.id.vpg_main);
        bottomNavigationView = findViewById(R.id.menu_bottom);
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(v-> onBackPressed());


    }

}