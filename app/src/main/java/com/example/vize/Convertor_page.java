package com.example.vize;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class Convertor_page extends AppCompatActivity {

    public String[] taban_turleri = {"bit", "octal", "hex"};
    public String[] byte_spinner = {"KB", "MB", "GB"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertor_page);
        Toast.makeText(this,"Convertor Sayfası", Toast.LENGTH_SHORT).show();

        Spinner taban, bytes;

        taban = findViewById(R.id.decimal_spanner);
        bytes = findViewById(R.id.byte_spanner);

        ArrayAdapter<String> tbn = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, taban_turleri);
        ArrayAdapter<String> byt = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, byte_spinner);

        bytes.setAdapter(byt);
        taban.setAdapter(tbn);
        EditText value = findViewById(R.id.inputs_decimal);
        EditText value2 = findViewById(R.id.inputs_byte);
        TextView result_dec = findViewById(R.id.decimal_sonuc);
        TextView result_byt = findViewById(R.id.byte_sonuc);

        EditText value3 = findViewById(R.id.input_derece);
        TextView result_derece = (TextView)findViewById(R.id.sonuc_derece);

        RadioButton f = findViewById(R.id.fahrenayt);
        RadioButton k = findViewById((R.id.kelvin));

        f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    if(f.isChecked())
                    {
                        int input = Integer.valueOf(value3.getText().toString());

                        result_derece.setText(String.valueOf(input*33.8));


                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(getBaseContext(), e.getMessage(),Toast.LENGTH_SHORT).show();

                }


            }
        });


        k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    if(k.isChecked())
                    {
                        int input = Integer.valueOf(value3.getText().toString());

                        result_derece.setText(String.valueOf(input+273));

                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(getBaseContext(), e.getMessage(),Toast.LENGTH_SHORT).show();

                }


            }
        });




        taban.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                try {

                    int input = Integer.valueOf(value.getText().toString());


                    String element = taban.getSelectedItem().toString();
                    Toast.makeText(getBaseContext(), element,Toast.LENGTH_SHORT).show();

                    if(element.equals("bit"))
                    {
                        String bit = Integer.toBinaryString(input);
                        result_dec.setText(bit.toString());

                    }
                    else if(element.equals("octal"))
                    {
                        String octal = Integer.toOctalString(input);
                        result_dec.setText(octal.toString());
                    }
                    else if(element.equals("hex"))
                    {
                        String hex = Integer.toHexString(input);
                        result_dec.setText(hex.toString());
                    }


                }
                catch (Exception e)
                {
                    Toast.makeText(getBaseContext(), e.getMessage(),Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }



        });

        bytes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                try {

                    int input = Integer.valueOf(value2.getText().toString());

                    String element = bytes.getSelectedItem().toString();

                    Toast.makeText(getBaseContext(), element,Toast.LENGTH_SHORT).show();

                    if(element.equals("KB"))
                    {
                        String kb = String.valueOf(input/1024);
                        result_byt.setText(kb.toString());

                    }
                    else if(element.equals("MB"))
                    {
                        String mb = String.valueOf((input/(1024*1024)));
                        result_byt.setText(mb.toString());
                    }
                    else if(element.equals("GB"))
                    {
                        String gb = String.valueOf((input/1073741824));
                        result_byt.setText(gb.toString());
                    }


                }
                catch (Exception e)
                {
                    Toast.makeText(getBaseContext(), e.getMessage(),Toast.LENGTH_SHORT).show();

                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}