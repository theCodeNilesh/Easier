package com.revolutioncoders.easier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Checkout extends AppCompatActivity {

    Button proceed_btn;
    RadioButton rb1,rb2, rb3;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        proceed_btn = findViewById(R.id.proceed_btn);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        rg = findViewById(R.id.radio_group);
//        rg.removeAllViews();
//        rg.addView(rb1);
//        rg.addView(rb2);
//        rg.addView(rb3);

        proceed_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Checkout.this, ThankYou.class);
                startActivity(intent);
            }
        });


    }
}