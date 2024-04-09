package com.example.pathsage;




import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SciencePCB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_pcb); // Update if your layout file name is different

        // Finding buttons by their IDs
        Button btnmedical = findViewById(R.id.btn_medical);
        Button btnpharm = findViewById(R.id.btn_Pharm);
        Button btnforensic = findViewById(R.id.btn_forensic);
        Button other=findViewById(R.id.btn_other);
        // Setting click listeners for each button
        btnmedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SciencePCB.this,Medical.class));
            }
        });

        btnpharm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SciencePCB.this,Pharmacy.class));
            }
        });

        btnforensic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SciencePCB.this,Forensic.class));
            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SciencePCB.this,Otherpcb.class));
            }
        });
    }

    // Helper method to show toast messages
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}


