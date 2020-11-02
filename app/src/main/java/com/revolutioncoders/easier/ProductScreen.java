package com.revolutioncoders.easier;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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
import static com.revolutioncoders.easier.URLenv.product_details;

public class ProductScreen extends AppCompatActivity {

    RequestQueue requestQueue;
    TextView title, quantity, priceView, details;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_screen);
        Bundle intent = getIntent().getExtras();
        final int id = intent.getInt("id");

        title = findViewById(R.id.product_name);
        quantity = findViewById(R.id.quantity);
        priceView = findViewById(R.id.first_rc_price);
        details = findViewById(R.id.product_details);
        btn = findViewById(R.id.add_cart);

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        Log.d("id", String.valueOf(id));

        StringRequest stringRequest = new StringRequest(Request.Method.POST, product_details,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            JSONArray jsonArray = object.getJSONArray("data");
                            List<CategoryItem> categoryItemList = new ArrayList<>();
                            for (int j = 0; j < jsonArray.length(); j++) {
                                JSONObject obj = jsonArray.getJSONObject(j);
                                String name = obj.getString("name");
                                int id = obj.getInt("product_id");
                                String price = obj.getString("price");
                                String des = obj.getString("in_stock");
                                title.setText(name);
                                priceView.setText(price);
                                details.setText(des);
                                Log.d("name", name);
                            }
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
                params.put("id", String.valueOf(id));
                return params;
            }
        };
        requestQueue.add(stringRequest);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}