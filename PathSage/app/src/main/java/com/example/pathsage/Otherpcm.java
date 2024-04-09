package com.example.pathsage;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class Otherpcm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otherpcm);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView careerProspectsDescription = findViewById(R.id.career_prospects_description2);
        String careerProspectsText = "B.Sc. in Physics, Chemistry, and Mathematics opens up various career paths, including:\n" +
                "- Research Scientist: Conducts scientific research in physics, chemistry, or mathematics.\n" +
                "- Data Analyst: Analyzes and interprets data using mathematical and statistical methods.\n" +
                "- Teacher/Educator: Educates students in physics, chemistry, or mathematics subjects.\n" +
                "- Environmental Scientist: Studies environmental issues and develops solutions using scientific principles.\n" +
                "- Financial Analyst: Applies mathematical models to analyze financial data and make investment decisions.\n" +
                "- Laboratory Technician: Assists in conducting experiments and analyzing scientific data.\n" +
                "- Software Developer: Develops software applications related to physics, chemistry, or mathematics.\n" +
                "- Actuary: Assesses financial risks using mathematical and statistical models.\n" +
                "- Quality Control Analyst: Ensures products meet quality standards through testing and analysis.\n" +
                "- Operations Research Analyst: Uses mathematical models to solve complex business problems.";

        careerProspectsDescription.setText(careerProspectsText);
    }
}
