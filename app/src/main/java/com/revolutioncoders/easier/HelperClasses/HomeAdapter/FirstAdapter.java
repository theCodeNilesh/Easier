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

public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.FirstViewHolder> {

    ArrayList<FirstHelperClass> firstLocations;

    //array list

    public FirstAdapter(ArrayList<FirstHelperClass> firstLocations) {
        this.firstLocations = firstLocations;
    }

    @NonNull
    //view
    @Override
    public FirstViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_card_design, parent, false);
        FirstViewHolder holder = new FirstViewHolder(view);
        return holder;
    }

    //bind the design and code
    @Override
    public void onBindViewHolder(@NonNull FirstViewHolder holder, int position) {

        FirstHelperClass firstHelperClass = firstLocations.get(position);
        holder.image.setImageResource(firstHelperClass.getImage());
        holder.title.setText(firstHelperClass.getTitle());
        holder.subtxt.setText(firstHelperClass.getSubtxt());
        holder.price.setText(firstHelperClass.getPrice());


    }

    @Override
    public int getItemCount() {
        return firstLocations.size();
    }

    //setting that view and hooks

    public static class FirstViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, subtxt, price;

        public FirstViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            image = itemView.findViewById(R.id.first_rc_img);
            title = itemView.findViewById(R.id.first_rc_title);
            subtxt = itemView.findViewById(R.id.first_rc_subtxt);
            price = itemView.findViewById(R.id.first_rc_price);


        }
    }
}
