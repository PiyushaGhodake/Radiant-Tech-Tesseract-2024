package com.example.pathsage;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Science extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science); // Update if your layout file name is different

        // Finding buttons by their IDs
        ImageButton btnPCM = findViewById(R.id.btn_pcm);
        ImageButton btnPCMB = findViewById(R.id.btn_pcmb);
        ImageButton btnPCB = findViewById(R.id.btn_pcb);

        // Setting click listeners for each button
        btnPCM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Science.this,SciencePCM.class));
            }
        });

        btnPCMB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Science.this,SciencePCMB.class));
            }
        });

        btnPCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Science.this,SciencePCB.class));
            }
        });
    }

    // Helper method to show toast messages
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}


