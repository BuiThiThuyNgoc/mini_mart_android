package com.example.mini_mart_android.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mini_mart_android.model.Product;
import com.example.mini_mart_android.R;
import com.example.mini_mart_android.listener.ClickItemListener;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private Context context;
    private List<Product> productList;
    public ClickItemListener clickItemListener;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_all, parent, false);

        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        if (product == null) {
            return;
        }
        holder.tv_productname.setText(product.getName());
        holder.tv_price_product.setText(String.valueOf(product.getPrice()));

    }
    @Override
    public int getItemCount() {
        if (productList != null) {
            return productList.size();
        }
        return 0;

    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{

        private ImageView img_product;
        private TextView tv_productname, tv_price_product;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            img_product = itemView.findViewById(R.id.imgAllProduct);
            tv_productname = itemView.findViewById(R.id.tvAllProductName);
            tv_price_product = itemView.findViewById(R.id.price_allProduct);
        }
    }
}
