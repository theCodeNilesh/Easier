package com.revolutioncoders.easier;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.revolutioncoders.easier.HelperClasses.HomeAdapter.BannerAdapter;
import com.revolutioncoders.easier.HelperClasses.HomeAdapter.BannerHelperClass;
import com.revolutioncoders.easier.HelperClasses.HomeAdapter.FirstAdapter;
import com.revolutioncoders.easier.HelperClasses.HomeAdapter.FirstHelperClass;
import com.revolutioncoders.easier.HelperClasses.HomeAdapter.SecondAdapter;
import com.revolutioncoders.easier.HelperClasses.HomeAdapter.SecondHelperClass;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {

    RecyclerView firstRecycler, bannerRecycler, secondRecycler;
    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAGS_CHANGED, WindowManager.LayoutParams.FLAGS_CHANGED);
        setContentView(R.layout.activity_home_screen);

        firstRecycler = findViewById(R.id.first_recycler);
        bannerRecycler = findViewById(R.id.banner_recycler);
        secondRecycler = findViewById(R.id.second_recycler);


        firstRecycler();
        bannerRecycler();
        secondRecycler();


    }

    private void secondRecycler() {
        secondRecycler.setHasFixedSize(true);
        secondRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<SecondHelperClass> secondLocations = new ArrayList<>();
        secondLocations.add(new SecondHelperClass(R.drawable.test_img4, "Papaya", "12 pcs - 500 to  900  gm", "25"));
        secondLocations.add(new SecondHelperClass(R.drawable.test_img5, "Potato", "12 pcs - 500 to  900  gm", "25"));
        secondLocations.add(new SecondHelperClass(R.drawable.test_img1, "Bell Paper", "12 pcs - 500 to  900  gm", "25"));

        adapter = new SecondAdapter((secondLocations));

        secondRecycler.setAdapter(adapter);
    }

    private void bannerRecycler() {

        bannerRecycler.setHasFixedSize(true);
        bannerRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<BannerHelperClass> bannerLocations = new ArrayList<>();

        bannerLocations.add(new BannerHelperClass(R.drawable.demo_banner1));
        bannerLocations.add(new BannerHelperClass(R.drawable.demo_banne2));

        adapter = new BannerAdapter((bannerLocations));
        bannerRecycler.setAdapter(adapter);

    }

    private void firstRecycler() {

        firstRecycler.setHasFixedSize(true);
        firstRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FirstHelperClass> firstLocations = new ArrayList<>();

        firstLocations.add(new FirstHelperClass(R.drawable.test_img1, "Bell Paper", "12 pcs - 500 to  900  gm", "29"));
        firstLocations.add(new FirstHelperClass(R.drawable.test_img2, "Tomatto", "20 pcs - 500 to  900  gm", "13"));
        firstLocations.add(new FirstHelperClass(R.drawable.test_img3, "Ginger", "3 pcs - 500 to  900  gm", "12"));

        adapter = new FirstAdapter((firstLocations));

        firstRecycler.setAdapter(adapter);

    }
}