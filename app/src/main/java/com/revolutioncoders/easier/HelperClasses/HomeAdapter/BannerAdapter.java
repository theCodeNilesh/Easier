package com.revolutioncoders.easier.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.revolutioncoders.easier.R;

import java.util.ArrayList;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {

    ArrayList<BannerHelperClass> bannerLocations;

    public BannerAdapter(ArrayList<BannerHelperClass> bannerLocations) {
        this.bannerLocations = bannerLocations;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_design, parent, false);
        BannerViewHolder bannerViewHolder = new BannerViewHolder((view));

        return bannerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {

        BannerHelperClass bannerHelperClass = bannerLocations.get(position);
        holder.banner_img.setImageResource(bannerHelperClass.getBanner_img());

    }

    @Override
    public int getItemCount() {
        return bannerLocations.size();
    }

    public static class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView banner_img;

        public BannerViewHolder(@NonNull View itemView) {


            super(itemView);

            // Hooks

            banner_img = itemView.findViewById(R.id.banner_img);

        }
    }
}
