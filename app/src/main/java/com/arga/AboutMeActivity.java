package com.arga;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AboutMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void openIG(View view) {
        Uri uri = Uri.parse("http://instagram.com/_u/argahutama");
        Intent followme = new Intent(Intent.ACTION_VIEW, uri);
        followme.setPackage("com.instagram.android");
        try {
            startActivity(followme);
        } catch (ActivityNotFoundException e){
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/argahutama")));
        }
    }
}