package com.arga;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CovidSymptomDetails extends AppCompatActivity {
    public static final String EXTRA_SYMPTOM = "extra_symptom";
    public static final String EXTRA_SYMPTOM_DETAILS = "extra_symptom_details";
    public static final String EXTRA_SYMPTOM_PICTURE = "extra_symptom_picture";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.symptom_details);

        TextView tvSymptom = findViewById(R.id.tv_symptom);
        TextView tvSymptomDetails = findViewById(R.id.tv_symptom_details);
        ImageView pictureSymptom = findViewById(R.id.img_symptom);

        String symptom = getIntent().getStringExtra(EXTRA_SYMPTOM);
        String symptomDetails = getIntent().getStringExtra(EXTRA_SYMPTOM_DETAILS);
        int symptomPicture = getIntent().getIntExtra(EXTRA_SYMPTOM_PICTURE, 0);

        tvSymptom.setText(symptom);
        tvSymptomDetails.setText(symptomDetails);
        pictureSymptom.setImageDrawable(getResources().getDrawable(symptomPicture));
    }
}