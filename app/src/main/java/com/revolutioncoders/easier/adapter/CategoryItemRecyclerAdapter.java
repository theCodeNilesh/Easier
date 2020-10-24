package com.revolutioncoders.easier.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.revolutioncoders.easier.R;
import com.revolutioncoders.easier.model.CategoryItem;

import java.util.List;

public class CategoryItemRecyclerAdapter extends RecyclerView.Adapter<CategoryItemRecyclerAdapter.CategoryItemViewHolder> {

    private Context context;
    private List<CategoryItem> categoryItemList;

    public CategoryItemRecyclerAdapter(Context context, List<CategoryItem> categoryItemList) {
        this.context = context;
        this.categoryItemList = categoryItemList;
    }

    @NonNull
    @Override
    public CategoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryItemViewHolder(LayoutInflater.from(context).inflate(R.layout.first_card_design, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryItemViewHolder holder, int position) {

        holder.itemImage.setImageResource(categoryItemList.get(position).getImageUrl());
        holder.title.setText(categoryItemList.get(position).getTitle());
        holder.subtxt.setText(categoryItemList.get(position).getSubtxt());
        holder.price.setText(categoryItemList.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public static final class CategoryItemViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView title, price, subtxt;


        public CategoryItemViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.first_rc_img);
            title = itemView.findViewById(R.id.first_rc_title);
            subtxt = itemView.findViewById(R.id.first_rc_subtxt);
            price = itemView.findViewById(R.id.first_rc_price);


        }
    }
}
