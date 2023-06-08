package com.example.mini_mart_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.mini_mart_android.database.CallApi;
import com.example.mini_mart_android.model.Product;
import com.example.mini_mart_android.Adapter.ProductAdapter;

public class ProductDetailPage extends AppCompatActivity {
    ImageView backProductDetail;
    List<Product> productList;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail_page);

        backProductDetail = findViewById(R.id.backProductDetail);
        productList = new ArrayList<>();
        productAdapter = new ProductAdapter(productList); // Pass productList to the constructor

        backProductDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductDetailPage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        loadDataFromApi();
    }

    private void loadDataFromApi() {
        CallApi.apiProduct.callProducts("product").enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    List<Product> allProducts = response.body();
                    if (allProducts != null && !allProducts.isEmpty()) {
                        int randomCount = 6;
                        Collections.shuffle(allProducts);
                        List<Product> limitedProducts = allProducts.subList(0, Math.min(allProducts.size(), randomCount));

                        productList.clear();
                        productList.addAll(limitedProducts);

                        productAdapter.notifyDataSetChanged();

                        // Assuming you have a RecyclerView
                        // recyclerView.setAdapter(productAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                // Handle the failure
            }
        });
    }
}
