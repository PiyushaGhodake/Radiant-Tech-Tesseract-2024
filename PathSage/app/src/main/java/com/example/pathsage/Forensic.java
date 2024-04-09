package com.example.pathsage;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class Forensic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forensic);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView careerProspectsDescription = findViewById(R.id.career_prospects_description4);
        String careerProspectsText = "Forensic Science offers diverse career opportunities, such as:\n" +
                "- Forensic Scientist: Analyzes physical evidence to assist in criminal investigations.\n" +
                "- Crime Scene Investigator (CSI): Processes crime scenes and collects evidence.\n" +
                "- Forensic Pathologist: Conducts autopsies and determines cause of death.\n" +
                "- Forensic Psychologist: Analyzes criminal behavior and mental health aspects.\n" +
                "- Forensic Accountant: Investigates financial crimes and fraud.\n" +
                "- Digital Forensics Analyst: Recovers digital evidence from electronic devices.\n" +
                "- Forensic Odontologist: Identifies human remains using dental records.\n" +
                "- Forensic Anthropologist: Studies skeletal remains for identification and analysis.\n" +
                "- Forensic Toxicologist: Analyzes bodily fluids for drugs and toxins.\n" +
                "- Forensic Entomologist: Studies insect activity on human remains for time estimation.";

        careerProspectsDescription.setText(careerProspectsText);
    }
}
