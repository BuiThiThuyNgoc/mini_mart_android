package com.example.mini_mart_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mini_mart_android.R;
import com.example.mini_mart_android.model.Category;
import java.util.List;
import android.net.Uri;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private Context context;
    private List<Category> categoryList;

    public CategoryAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Category> list) {
        this.categoryList = list;
        notifyDataSetChanged();

}
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categoryList.get(position);
        if (category == null) {
            return;
        }
        holder.tv_namecategory.setText(category.getName());
        holder.tv_description.setText(category.getDescription());
        Glide.with(context)
                .load(category.getUrlImage())
                .into(holder.img_category);
    }

    @Override
    public int getItemCount() {
        if (categoryList != null) {
            return categoryList.size();
        }
        return 0;

    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        private ImageView img_category;
        private TextView tv_namecategory, tv_description;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            img_category = itemView.findViewById(R.id.img_pop);
            tv_namecategory = itemView.findViewById(R.id.tv_pop_name);
            tv_description = itemView.findViewById(R.id.tv_pop_des);

        }
    }
}
