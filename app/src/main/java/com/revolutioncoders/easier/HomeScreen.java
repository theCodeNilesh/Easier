package com.revolutioncoders.easier;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.revolutioncoders.easier.HelperClasses.HomeAdapter.BannerAdapter;
import com.revolutioncoders.easier.HelperClasses.HomeAdapter.BannerHelperClass;
import com.revolutioncoders.easier.adapter.MainRecyclerAdapter;
import com.revolutioncoders.easier.model.AllCategory;
import com.revolutioncoders.easier.model.CategoryItem;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends AppCompatActivity {

    RecyclerView bannerRecycler, mainCategoryRecycler;
    RecyclerView.Adapter adapter;

    MainRecyclerAdapter mainRecyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAGS_CHANGED, WindowManager.LayoutParams.FLAGS_CHANGED);
        setContentView(R.layout.activity_home_screen);

        bannerRecycler = findViewById(R.id.banner_recycler);

        bannerRecycler();

        List<CategoryItem> categoryItemList = new ArrayList<>();
        categoryItemList.add(new CategoryItem(1, R.drawable.test_img1, "30", "Item1", "12 pcs - 500 to  900  gm"));
        categoryItemList.add(new CategoryItem(1, R.drawable.test_img2, "30", "Item1", "12 pcs - 500 to  900  gm"));
        categoryItemList.add(new CategoryItem(1, R.drawable.test_img3, "30", "Item1", "12 pcs - 500 to  900  gm"));
        categoryItemList.add(new CategoryItem(1, R.drawable.test_img4, "30", "Item1", "12 pcs - 500 to  900  gm"));
        categoryItemList.add(new CategoryItem(1, R.drawable.test_img5, "30", "Item1", "12 pcs - 500 to  900  gm"));


        List<CategoryItem> categoryItemList2 = new ArrayList<>();
        categoryItemList2.add(new CategoryItem(1, R.drawable.test_img1, "30", "Item1", "12 pcs - 500 to  900  gm"));
        categoryItemList2.add(new CategoryItem(1, R.drawable.test_img2, "30", "Item1", "12 pcs - 500 to  900  gm"));
        categoryItemList2.add(new CategoryItem(1, R.drawable.test_img3, "30", "Item1", "12 pcs - 500 to  900  gm"));
        categoryItemList2.add(new CategoryItem(1, R.drawable.test_img4, "30", "Item1", "12 pcs - 500 to  900  gm"));
        categoryItemList2.add(new CategoryItem(1, R.drawable.test_img5, "30", "Item1", "12 pcs - 500 to  900  gm"));


        List<CategoryItem> categoryItemList3 = new ArrayList<>();
        categoryItemList3.add(new CategoryItem(1, R.drawable.test_img1, "30", "Item1", "12 pcs - 500 to  900  gm"));
        categoryItemList3.add(new CategoryItem(1, R.drawable.test_img2, "30", "Item1", "12 pcs - 500 to  900  gm"));
        categoryItemList3.add(new CategoryItem(1, R.drawable.test_img3, "30", "Item1", "12 pcs - 500 to  900  gm"));
        categoryItemList3.add(new CategoryItem(1, R.drawable.test_img4, "30", "Item1", "12 pcs - 500 to  900  gm"));
        categoryItemList3.add(new CategoryItem(1, R.drawable.test_img5, "30", "Item1", "12 pcs - 500 to  900  gm"));


        List<AllCategory> allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory("New Stock", categoryItemList));
        allCategoryList.add(new AllCategory("Chocolate", categoryItemList2));
        allCategoryList.add(new AllCategory("Vegetables", categoryItemList3));
        setMainCategoryRecycler(allCategoryList);


    }


    private void setMainCategoryRecycler(List<AllCategory> allCategoryList) {

        mainCategoryRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainCategoryRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this, allCategoryList);
        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);
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


}