package com.example.mini_mart_android.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mini_mart_android.ContinuesAccount;
import com.example.mini_mart_android.R;


public class AccountFragment extends Fragment {
    private View view;
    private Button btn;
    private ImageView imgView_setting;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_account, container, false);
        btn = view.findViewById(R.id.btn_continue);
        imgView_setting = view.findViewById(R.id.imgView_setting);





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), ContinuesAccount.class);
                startActivity(intent);

            }
        });
        return  view;
    }


}