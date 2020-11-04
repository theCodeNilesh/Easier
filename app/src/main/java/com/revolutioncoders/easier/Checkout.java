package com.revolutioncoders.easier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Checkout extends AppCompatActivity {

    Button proceed_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        proceed_btn = findViewById(R.id.proceed_btn);


        proceed_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Checkout.this, ThankYou.class);
                startActivity(intent);
            }
        });


    }
}