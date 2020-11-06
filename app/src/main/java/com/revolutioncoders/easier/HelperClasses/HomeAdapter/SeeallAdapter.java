package com.revolutioncoders.easier.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.revolutioncoders.easier.R;

import java.util.ArrayList;

public class SeeallAdapter extends RecyclerView.Adapter<SeeallAdapter.SeeallViewHolder> {

    ArrayList<SeeallHelperClass> seeallLocations;

    public SeeallAdapter(ArrayList<SeeallHelperClass> seeallLocations) {
        this.seeallLocations = seeallLocations;
    }

    @NonNull
    @Override
    public SeeallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seeall_product_design,parent,false);
        SeeallAdapter.SeeallViewHolder cartViewHolder = new SeeallAdapter.SeeallViewHolder(view);

        return cartViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SeeallViewHolder holder, int position) {

        SeeallHelperClass seeallHelperClass= seeallLocations.get(position);
        holder.image.setImageResource(seeallHelperClass.getImage());
        holder.title.setText(seeallHelperClass.getTitle());
        holder.price.setText(seeallHelperClass.getPrice());
        holder.subtxt.setText(seeallHelperClass.getSubtxt());
    }

    @Override
    public int getItemCount() {
        return seeallLocations.size();
    }

    public static class SeeallViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, price, subtxt;

        public SeeallViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks

            image = itemView.findViewById(R.id.seeall_img);
            title = itemView.findViewById(R.id.seeall_title);
            price = itemView.findViewById(R.id.seeall_price);
            subtxt = itemView.findViewById(R.id.seeall_subtxt);
        }
    }
}
