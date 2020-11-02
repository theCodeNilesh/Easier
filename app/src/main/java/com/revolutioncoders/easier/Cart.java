package com.revolutioncoders.easier;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.revolutioncoders.easier.HelperClasses.HomeAdapter.CartAdapter;
import com.revolutioncoders.easier.HelperClasses.HomeAdapter.CartHelperClass;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    RecyclerView cartRecycler;
    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        cartRecycler = findViewById(R.id.cart_recycler);

        cartRecycler();

    }

    private void cartRecycler() {

        cartRecycler.setHasFixedSize(true);
        cartRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<CartHelperClass> cartLocations = new ArrayList<>();
        cartLocations.add(new CartHelperClass(R.drawable.tomatto, "Tomatto", "29", "2 kg"));
        cartLocations.add(new CartHelperClass(R.drawable.tomatto, "Tomatto", "29", "2 kg"));
        cartLocations.add(new CartHelperClass(R.drawable.tomatto, "Tomatto", "29", "2 kg"));
        cartLocations.add(new CartHelperClass(R.drawable.tomatto, "Tomatto", "29", "2 kg"));
        cartLocations.add(new CartHelperClass(R.drawable.tomatto, "Tomatto", "29", "2 kg"));
        cartLocations.add(new CartHelperClass(R.drawable.tomatto, "Tomatto", "29", "2 kg"));
        cartLocations.add(new CartHelperClass(R.drawable.tomatto, "Tomatto", "29", "2 kg"));


        adapter = new CartAdapter(cartLocations);
        cartRecycler.setAdapter(adapter);
    }
}