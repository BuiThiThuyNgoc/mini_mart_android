package com.example.mini_mart_android.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mini_mart_android.Adapter.CategoryAdapter;
import com.example.mini_mart_android.Adapter.ProductAdapter;
import com.example.mini_mart_android.CartPage;
import com.example.mini_mart_android.Header;
import com.example.mini_mart_android.R;
import com.example.mini_mart_android.database.CallApi;
import com.example.mini_mart_android.model.Category;
import com.example.mini_mart_android.model.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;








public class CategoryFragment extends Fragment {

    private View view;
    private ImageView IvSetting, imgView_cart;
    private ProductAdapter productAdapter;
    private CategoryAdapter categoryAdapter;
    private RecyclerView recyclerView;
    private List<Product> productList = new ArrayList<>();
    private List<Category> categoryList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_product, container, false);
        IvSetting = view.findViewById(R.id.imgView_setting);
        imgView_cart = view.findViewById(R.id.imgView_cart);
        recyclerView = view.findViewById(R.id.categoryRecycler);


        productAdapter = new ProductAdapter(productList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(productAdapter);
        loadDataCategory(requireContext());

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
    private void loadDataCategory(Context context) {
        CallApi.apiCategory.callCategories("categories").enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful()) {
                    categoryList.clear();
                    categoryList.addAll(response.body());

                    categoryAdapter = new CategoryAdapter(context); // Initialize categoryAdapter with the provided context
                    recyclerView.setAdapter(categoryAdapter);

                    categoryAdapter.setData(categoryList); // Update the data in the adapter
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                // Handle failure
            }
        });
    }

}