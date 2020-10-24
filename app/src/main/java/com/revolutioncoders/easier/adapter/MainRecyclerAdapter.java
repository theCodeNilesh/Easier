package com.revolutioncoders.easier.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.revolutioncoders.easier.R;
import com.revolutioncoders.easier.model.AllCategory;
import com.revolutioncoders.easier.model.CategoryItem;

import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder> {

    private Context context;
    private List<AllCategory> allCategoriesList;

    public MainRecyclerAdapter(Context context, List<AllCategory> allCategoriesList) {
        this.context = context;
        this.allCategoriesList = allCategoriesList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.main_recycler_row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {

        holder.categoryTitle.setText(allCategoriesList.get(position).getCategoryTitle());
        seteCatItemRecycler(holder.itemRecycler, allCategoriesList.get(position).getCategoryItemList());

    }

    @Override
    public int getItemCount() {
        return allCategoriesList.size();
    }

    private void seteCatItemRecycler(RecyclerView recyclerView, List<CategoryItem> categoryItemList) {

        CategoryItemRecyclerAdapter itemRecyclerAdapter = new CategoryItemRecyclerAdapter(context, categoryItemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(itemRecyclerAdapter);

    }

    public static final class MainViewHolder extends RecyclerView.ViewHolder {

        TextView categoryTitle;
        RecyclerView itemRecycler;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryTitle = itemView.findViewById(R.id.cat_title);
            itemRecycler = itemView.findViewById(R.id.item_recycler);

        }
    }
}
