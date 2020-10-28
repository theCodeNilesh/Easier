package com.revolutioncoders.easier;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import static com.revolutioncoders.easier.URLenv.category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TextView easier;
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        easier = findViewById(R.id.easier);
        final ArrayList<String> cat_array = new ArrayList<String>();
        final ArrayList<String> cat_id = new ArrayList<String>();


        //Text Animation

        easier.setAlpha((float) 0.0);
        easier.setTranslationY(20);

        easier.animate().alpha((float) 1.0).setDuration(800).setStartDelay(250);
        easier.animate().translationY(0).setDuration(400).setStartDelay(250);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            final WindowInsetsController insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.statusBars());
            }
        } else {
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            );
        }

        final Thread background = new Thread() {
            public void run() {
                try {
                    // Thread will sleep for 5 seconds
                    sleep(500);
                    StringRequest stringRequest = new StringRequest(Request.Method.POST,category ,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONObject object = new JSONObject(response);
                                        JSONArray jsonArray = object.getJSONArray("data");
                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            JSONObject obj = jsonArray.getJSONObject(i);
                                            String name = obj.getString("category_name");
                                            String id = obj.getString("category_id");
                                            cat_array.add(name);
                                            cat_id.add(id);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    Intent intent = new Intent(SplashScreen.this, HomeScreen.class);
                                    Bundle args = new Bundle();
                                    args.putSerializable("ARRAYLIST",(Serializable)cat_array);
                                    intent.putExtra("BUNDLE",args);
                                    Bundle args1 = new Bundle();
                                    args1.putSerializable("ARRAYLIST1",(Serializable)cat_id);
                                    intent.putExtra("BUNDLE1",args1);
                                    startActivity(intent);
                                    finish();
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                        }
                    });
                    requestQueue.add(stringRequest);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        // start thread
        background.start();
    }
}