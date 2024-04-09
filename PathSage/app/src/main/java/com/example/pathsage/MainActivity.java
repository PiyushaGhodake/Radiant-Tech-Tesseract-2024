package com.example.pathsage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.hbb20.CountryCodePicker;


public class MainActivity extends AppCompatActivity {



    CountryCodePicker countryCodePicker;
    EditText t1;
    ProgressBar progressBar;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(EditText) findViewById(R.id.login_mobile_number);
        b1=(Button) findViewById(R.id.send_otp_btn);
        progressBar = findViewById(R.id.login_progress_bar);

        progressBar.setVisibility(View.GONE);
        countryCodePicker=(CountryCodePicker) findViewById(R.id.login_countrycode);
        countryCodePicker.registerCarrierNumberEditText(t1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,OptActivity.class);
                i.putExtra("mobile",countryCodePicker.getFullNumberWithPlus().replace(" ",""));
                startActivity(i);
            }
        });



    }
}