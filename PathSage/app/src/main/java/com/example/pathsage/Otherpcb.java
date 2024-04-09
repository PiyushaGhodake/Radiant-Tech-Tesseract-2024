package com.example.pathsage;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class Otherpcb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otherpcb);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView careerProspectsDescription = findViewById(R.id.career_prospects_description3);
        String careerProspectsText = "B.Sc. in Physics, Chemistry, and Biology offers diverse career opportunities, such as:\n" +
                "- Biotechnologist: Researches and develops biotechnology products and processes.\n" +
                "- Pharmaceutical Scientist: Works in drug development and pharmaceutical research.\n" +
                "- Environmental Consultant: Assesses environmental impact and advises on conservation measures.\n" +
                "- Forensic Scientist: Analyzes evidence for legal investigations using scientific methods.\n" +
                "- Healthcare Professional: Pursues careers in medicine, nursing, or allied health professions.\n" +
                "- Microbiologist: Studies microorganisms and their effects on humans, animals, and the environment.\n" +
                "- Geneticist: Researches genetic traits and inheritance patterns in organisms.\n" +
                "- Botanist: Studies plant life, including growth, development, and environmental interactions.\n" +
                "- Zoologist: Investigates animal behavior, physiology, and ecosystems.\n" +
                "- Conservation Scientist: Works to preserve natural resources and ecosystems.";

        careerProspectsDescription.setText(careerProspectsText);
    }
}
