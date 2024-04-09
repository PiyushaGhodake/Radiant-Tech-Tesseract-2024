package com.example.pathsage;




import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SciencePCM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_pcm); // Update if your layout file name is different

        // Finding buttons by their IDs
        Button btneng = findViewById(R.id.btn_engineering);
        Button btnarch = findViewById(R.id.btn_arch);
         Button btnother = findViewById(R.id.btn_other1);

        // Setting click listeners for each button
        btneng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SciencePCM.this,Engineering.class));
            }
        });

        btnarch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SciencePCM.this,Arch.class));
            }
        });

        btnother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SciencePCM.this,Otherpcm.class));
            }
        });
    }

    // Helper method to show toast messages
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}


