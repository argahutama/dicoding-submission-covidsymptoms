package com.arga;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String title = "Covid19 Symptoms - by Arga";
    private RecyclerView rvSymptoms;
    private ArrayList<Symptoms> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle(title);

        rvSymptoms = findViewById(R.id.rv_symptoms);
        rvSymptoms.setHasFixedSize(true);

        list.addAll(CovidSymptomData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvSymptoms.setLayoutManager(new LinearLayoutManager(this));
        CovidSymptomLists covidSymptomLists = new CovidSymptomLists(list);
        rvSymptoms.setAdapter(covidSymptomLists);
        covidSymptomLists.setOnItemClickCallback(new CovidSymptomLists.OnItemClickCallback() {
            @Override
            public void onItemClicked(Symptoms symptoms) {
                viewSymptomDetails(symptoms);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.info:
                Intent worldometersIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.worldometers.info/coronavirus"));
                startActivity(worldometersIntent);
                return true;
            case R.id.whoinfo:
                Intent whoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.who.int/emergencies/diseases/novel-coronavirus-2019"));
                startActivity(whoIntent);
                return true;
            case R.id.about:
                startActivity(new Intent(this, AboutMeActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void viewSymptomDetails(Symptoms symptoms) {
        Intent moveToPersonalityDetail = new Intent(MainActivity.this, CovidSymptomDetails.class);
        moveToPersonalityDetail.putExtra(CovidSymptomDetails.EXTRA_SYMPTOM, symptoms.getSymptoms());
        moveToPersonalityDetail.putExtra(CovidSymptomDetails.EXTRA_SYMPTOM_DETAILS, symptoms.getSymptomDetails());
        moveToPersonalityDetail.putExtra(CovidSymptomDetails.EXTRA_SYMPTOM_PICTURE, symptoms.getSymptomPictures());
        startActivity(moveToPersonalityDetail);
    }
}