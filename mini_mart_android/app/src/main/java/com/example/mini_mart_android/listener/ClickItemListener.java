package com.example.mini_mart_android.listener;

import com.example.mini_mart_android.model.Product;
import com.example.mini_mart_android.model.Category;

public interface ClickItemListener {
    public void onClickItem(Product product);
    public void onClickItem(Category category);
}
