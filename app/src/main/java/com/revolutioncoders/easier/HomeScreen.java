package com.revolutioncoders.easier;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.revolutioncoders.easier.HelperClasses.HomeAdapter.BannerAdapter;
import com.revolutioncoders.easier.HelperClasses.HomeAdapter.BannerHelperClass;
import com.revolutioncoders.easier.adapter.MainRecyclerAdapter;
import com.revolutioncoders.easier.model.AllCategory;
import com.revolutioncoders.easier.model.CategoryItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.revolutioncoders.easier.URLenv.product;

public class HomeScreen extends AppCompatActivity {

    RecyclerView bannerRecycler, mainCategoryRecycler;
    RecyclerView.Adapter adapter;
    RequestQueue requestQueue;
    MainRecyclerAdapter mainRecyclerAdapter;
    EditText searchbar;
    ImageView cart_ic, menu_ic;


    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAGS_CHANGED, WindowManager.LayoutParams.FLAGS_CHANGED);
        setContentView(R.layout.activity_home_screen);

        searchbar = findViewById(R.id.searchbar);
        cart_ic = findViewById(R.id.cart_ic);
        menu_ic = findViewById(R.id.menu_ic);

        bannerRecycler = findViewById(R.id.banner_recycler);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        bannerRecycler();


        searchbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, ProductScreen.class);
                startActivity(intent);
            }
        });

        cart_ic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, SeeAll.class);
                startActivity(intent);
            }
        });

        menu_ic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, Profile.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        final ArrayList<String> cat_array = (ArrayList<String>) args.getSerializable("ARRAYLIST");

        Bundle args1 = intent.getBundleExtra("BUNDLE1");
        final ArrayList<String> cat_id = (ArrayList<String>) args1.getSerializable("ARRAYLIST1");


        List<AllCategory> allCategoryList = new ArrayList<>();
        for (i = 0; i < cat_array.size(); i++) {
            Log.d("p", cat_array.get(i));
            getData(cat_id.get(i), cat_array.get(i), allCategoryList);
        }
        try {
            Thread.sleep(500);
            setMainCategoryRecycler(allCategoryList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private void getData(final String i, final String cat, final List<AllCategory> all) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, product,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("p1", String.valueOf(i));
                        try {
                            int flag = 0;
                            JSONObject object = new JSONObject(response);
                            JSONArray jsonArray = object.getJSONArray("data");
                            List<CategoryItem> categoryItemList = new ArrayList<>();
                            for (int j = 0; j < jsonArray.length(); j++) {
                                JSONObject obj = jsonArray.getJSONObject(j);
                                String name = obj.getString("name");
                                int id = obj.getInt("product_id");
                                String price = obj.getString("price");
                                String des = obj.getString("in_stock");
                                String image = obj.getString("image");
                                Log.d("n1", cat);
                                Log.d("n", name);
                                if (name.equals(""))
                                    flag = 0;
                                else {
                                    categoryItemList.add(new CategoryItem(id, image, price, name, des));
                                    flag = 1;
                                }
                            }
                            if (flag == 1)
                                all.add(new AllCategory(cat, categoryItemList));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("cat_id", String.valueOf(i));
                return params;
            }
        };
        requestQueue.add(stringRequest);
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