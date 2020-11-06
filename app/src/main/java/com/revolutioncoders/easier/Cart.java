package com.revolutioncoders.easier;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
import com.revolutioncoders.easier.HelperClasses.HomeAdapter.CartAdapter;
import com.revolutioncoders.easier.HelperClasses.HomeAdapter.CartHelperClass;
import com.revolutioncoders.easier.model.CategoryItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.revolutioncoders.easier.URLenv.get_cart;

public class Cart extends AppCompatActivity {

    RecyclerView cartRecycler;
    RecyclerView.Adapter adapter;
    RequestQueue requestQueue;
    Button complete_btn;
    TextView total;
    ArrayList<CartHelperClass> cartLocations;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        cartRecycler = findViewById(R.id.cart_recycler);
        complete_btn = findViewById(R.id.complete_btn);
        total = findViewById(R.id.total_price);

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

        cartLocations = new ArrayList<>();
//        cartLocations.add(new CartHelperClass(R.drawable.tomatto, "Tomatto", "29", "2 kg"));
//        cartLocations.add(new CartHelperClass(R.drawable.tomatto, "Tomatto", "29", "2 kg"));
//        cartLocations.add(new CartHelperClass(R.drawable.tomatto, "Tomatto", "29", "2 kg"));
//        cartLocations.add(new CartHelperClass(R.drawable.tomatto, "Tomatto", "29", "2 kg"));
//        cartLocations.add(new CartHelperClass(R.drawable.tomatto, "Tomatto", "29", "2 kg"));
//        cartLocations.add(new CartHelperClass(R.drawable.tomatto, "Tomatto", "29", "2 kg"));
//        cartLocations.add(new CartHelperClass(R.drawable.tomatto, "Tomatto", "29", "2 kg"));

        StringRequest stringRequest = new StringRequest(Request.Method.POST, get_cart,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            JSONArray jsonArray = object.getJSONArray("data");
                            String t = object.getString("total");
                            total.setText(t);
                            for (int j = 0; j < jsonArray.length(); j++) {
                                JSONObject obj = jsonArray.getJSONObject(j);
                                String name = obj.getString("p");
                                String quantity = obj.getString("quantity");
                                int id = obj.getInt("cart_id");
                                int pid = obj.getInt("product_id");
                                String q_type = obj.getString("quantity_type");
                                String price = obj.getString("price");
                                String img = obj.getString("image");
                                cartLocations.add(new CartHelperClass(img, name, price, quantity.concat(" ").concat(q_type),id,pid));
                            }
                            adapter = new CartAdapter(cartLocations);
                            cartRecycler.setAdapter(adapter);
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
                params.put("id", String.valueOf(1));
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

}