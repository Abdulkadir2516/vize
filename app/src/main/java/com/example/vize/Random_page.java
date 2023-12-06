package com.example.vize;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Random;

public class Random_page extends AppCompatActivity {

    //@SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_page);
        Toast.makeText(this,"Random Sayfası", Toast.LENGTH_SHORT).show();



            EditText adet = findViewById(R.id.adet);
            EditText max = findViewById(R.id.max);
            EditText min = findViewById(R.id.min);
            Button btn = findViewById(R.id.button);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try
                    {
                        ProgressBar newProgress = new ProgressBar(getBaseContext(), null, android.R.attr.progressBarStyleHorizontal);

                        int maks = Integer.valueOf(max.getText().toString());
                        int minn = Integer.valueOf(min.getText().toString());

                        maks = 500;
                        minn = 100;

                        int minvalue = newRandom(maks-1,minn+1);
                        int maxvalue = newRandom(maks-1,minn+1);

                        int gecici = maxvalue;
                        if(maxvalue<minvalue)
                        {
                            maxvalue = minvalue;
                            minvalue = gecici;
                        }

                        int rnd_sayı = newRandom(minvalue-1,minvalue+1);

                        newProgress.setMax(maxvalue);
                        newProgress.setProgress(rnd_sayı);

                        //newProgress.setMin(50);

                        LinearLayout layout = findViewById(R.id.barlar);

                        layout.addView(newProgress);

                    }
                    catch (Exception e)
                    {
                        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                }
            });

















    }

    public int newRandom(int max,int min)
    {
        Random rnd = new Random();
        return rnd.nextInt(max-min + 1) + min;
    }

}