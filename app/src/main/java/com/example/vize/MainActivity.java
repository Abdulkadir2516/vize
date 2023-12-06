package com.example.vize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sms,convert,rnd;

        convert = findViewById(R.id.convert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent convert_sayfası = new Intent(MainActivity.this, Convertor_page.class);
                startActivity(convert_sayfası);

            }
        });

        rnd = findViewById(R.id.random);

        rnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent random_sayfası = new Intent(MainActivity.this, Random_page.class);
                startActivity(random_sayfası);

            }
        });

        sms = findViewById(R.id.sms);

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sms_sayfası = new Intent(MainActivity.this, Sms_page.class);
                startActivity(sms_sayfası);

            }
        });

    }
}