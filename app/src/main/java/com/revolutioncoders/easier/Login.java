package com.revolutioncoders.easier;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
import static com.revolutioncoders.easier.URLenv.send_otp;

public class Login extends AppCompatActivity {
    RequestQueue requestQueue;

    String otp;
    String url;
    Button login_btn;
    SharedPreferences sp;
    EditText phone,otpEdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        login_btn = findViewById(R.id.login_btn);
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = login_btn.getText().equals("Send OTP")? send_otp:product;
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if (url.equals("Send OTP")) {
                                    otp = response;
                                    login_btn.setText("Login");
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
                        return params;
                    }
                };
                requestQueue.add(stringRequest);

                Intent intent = new Intent(Login.this, HomeScreen.class);
                startActivity(intent);

            }
        });
    }
}