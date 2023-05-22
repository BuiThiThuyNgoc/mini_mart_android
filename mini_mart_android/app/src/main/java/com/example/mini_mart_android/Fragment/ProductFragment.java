package com.example.mini_mart_android.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mini_mart_android.CartPage;
import com.example.mini_mart_android.Header;
import com.example.mini_mart_android.R;


public class ProductFragment extends Fragment {

    private View view;
    private ImageView IvSetting, imgView_cart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_product, container, false);
        IvSetting = view.findViewById(R.id.imgView_setting);
        imgView_cart = view.findViewById(R.id.imgView_cart);

        imgView_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CartPage.class);
                startActivity(intent);
            }
        });

        IvSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Header.class);
                startActivity(intent);
            }
        });
        return view;
    }
}