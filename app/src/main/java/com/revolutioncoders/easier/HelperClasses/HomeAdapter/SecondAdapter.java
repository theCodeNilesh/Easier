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

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.SecondViewHolder> {

    ArrayList<SecondHelperClass> secondLocations;

    public SecondAdapter(ArrayList<SecondHelperClass> secondLocations) {
        this.secondLocations = secondLocations;
    }

    @NonNull
    @Override
    public SecondViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.second_card_design, parent, false);
        SecondViewHolder secondViewHolder = new SecondViewHolder(view);
        return secondViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SecondViewHolder holder, int position) {

        SecondHelperClass secondHelperClass = secondLocations.get(position);
        holder.image2.setImageResource(secondHelperClass.getImage2());
        holder.title2.setText(secondHelperClass.getTitle2());
        holder.subtxt2.setText(secondHelperClass.getSubtxt2());
        holder.price2.setText(secondHelperClass.getPrice2());

    }

    @Override
    public int getItemCount() {
        return secondLocations.size();
    }

    public static class SecondViewHolder extends RecyclerView.ViewHolder {

        ImageView image2;
        TextView title2, subtxt2, price2;

        public SecondViewHolder(@NonNull View itemView) {
            super(itemView);
            //Hooks
            image2 = itemView.findViewById(R.id.second_rc_img);
            title2 = itemView.findViewById(R.id.second_rc_title);
            subtxt2 = itemView.findViewById(R.id.second_rc_subtxt);
            price2 = itemView.findViewById(R.id.second_rc_price);

        }
    }
}
