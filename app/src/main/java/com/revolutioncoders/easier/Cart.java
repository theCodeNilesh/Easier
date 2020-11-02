package com.revolutioncoders.easier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.revolutioncoders.easier.HelperClasses.HomeAdapter.CartAdapter;
import com.revolutioncoders.easier.HelperClasses.HomeAdapter.CartHelperClass;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    RecyclerView cartRecycler;
    RecyclerView.Adapter adapter;
    Button complete_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        cartRecycler = findViewById(R.id.cart_recycler);
        complete_btn = findViewById(R.id.complete_btn);


        complete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cart.this, Checkout.class);
                startActivity(intent);
            }
        });

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