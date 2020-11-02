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

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    ArrayList<CartHelperClass> cartLocations;

    public CartAdapter(ArrayList<CartHelperClass> cartLocations) {
        this.cartLocations = cartLocations;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_design, parent, false);
        CartViewHolder cartViewHolder = new CartViewHolder(view);
        return cartViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        CartHelperClass cartHelperClass = cartLocations.get(position);
        holder.image.setImageResource(cartHelperClass.getImage());
        holder.title.setText(cartHelperClass.getTitle());
        holder.price.setText(cartHelperClass.getPrice());
        holder.quantity.setText(cartHelperClass.getQuantity());

    }

    @Override
    public int getItemCount() {
        return cartLocations.size();
    }


    public static class CartViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, price, quantity;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks

            image = itemView.findViewById(R.id.cart_img);
            title = itemView.findViewById(R.id.cart_title);
            price = itemView.findViewById(R.id.cart_price);
            quantity = itemView.findViewById(R.id.cart_quantity);
        }
    }
}
