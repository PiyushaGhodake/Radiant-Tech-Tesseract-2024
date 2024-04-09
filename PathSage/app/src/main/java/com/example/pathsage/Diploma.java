package com.example.pathsage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class Diploma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diploma);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView careerProspectsDescription = findViewById(R.id.career_prospects_description1);
        String careerProspectsText = "Engineering offers various branches, including:\n" +
                "- Mechanical Engineering: Deals with mechanical systems and machines.\n" +
                "- Electrical Engineering: Focuses on electrical systems and electronics.\n" +
                "- Civil Engineering: Involves infrastructure design and construction.\n" +
                "- Computer Engineering: Combines computer science and electrical engineering.\n" +
                "- Chemical Engineering: Deals with chemical processes and materials.\n" +
                "- Biomedical Engineering: Integrates engineering and biology for medical applications.\n" +
                "- Aerospace Engineering: Focuses on aircraft and spacecraft design.\n" +
                "- Environmental Engineering: Addresses environmental protection and sustainability.\n" +
                "- Industrial Engineering: Optimizes complex systems for efficiency.\n" +
                "- Software Engineering: Develops software systems and applications.";

        careerProspectsDescription.setText(careerProspectsText);

    }
}