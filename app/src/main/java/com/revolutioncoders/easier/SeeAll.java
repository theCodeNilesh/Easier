package com.revolutioncoders.easier;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.revolutioncoders.easier.HelperClasses.HomeAdapter.SeeallAdapter;
import com.revolutioncoders.easier.HelperClasses.HomeAdapter.SeeallHelperClass;

import java.util.ArrayList;

public class SeeAll extends AppCompatActivity {

    RecyclerView seeallRecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all);

        seeallRecycler = findViewById(R.id.seeall_recycler);

        seeallRecycler();

    }

    private void seeallRecycler() {
        seeallRecycler.setHasFixedSize(true);
        seeallRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<SeeallHelperClass> seeallLocations = new ArrayList<>();
        seeallLocations.add(new SeeallHelperClass(R.drawable.tomatto,"Tomatto","23","12 pcs - 500 to  900  gm"));
        seeallLocations.add(new SeeallHelperClass(R.drawable.tomatto,"Tomatto","23","12 pcs - 500 to  900  gm"));
        seeallLocations.add(new SeeallHelperClass(R.drawable.tomatto,"Tomatto","23","12 pcs - 500 to  900  gm"));
        seeallLocations.add(new SeeallHelperClass(R.drawable.tomatto,"Tomatto","23","12 pcs - 500 to  900  gm"));
        seeallLocations.add(new SeeallHelperClass(R.drawable.tomatto,"Tomatto","23","12 pcs - 500 to  900  gm"));
        seeallLocations.add(new SeeallHelperClass(R.drawable.tomatto,"Tomatto","23","12 pcs - 500 to  900  gm"));
        seeallLocations.add(new SeeallHelperClass(R.drawable.tomatto,"Tomatto","23","12 pcs - 500 to  900  gm"));
        seeallLocations.add(new SeeallHelperClass(R.drawable.tomatto,"Tomatto","23","12 pcs - 500 to  900  gm"));
        seeallLocations.add(new SeeallHelperClass(R.drawable.tomatto,"Tomatto","23","12 pcs - 500 to  900  gm"));
        seeallLocations.add(new SeeallHelperClass(R.drawable.tomatto,"Tomatto","23","12 pcs - 500 to  900  gm"));
        seeallLocations.add(new SeeallHelperClass(R.drawable.tomatto,"Tomatto","23","12 pcs - 500 to  900  gm"));
        seeallLocations.add(new SeeallHelperClass(R.drawable.tomatto,"Tomatto","23","12 pcs - 500 to  900  gm"));

        adapter = new SeeallAdapter(seeallLocations);
        seeallRecycler.setAdapter(adapter);


    }
}