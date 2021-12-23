package com.example.manyacovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.manyacovid19.ui.country.CovidCountry;

public class CovidCountryDetail extends AppCompatActivity {

    TextView tvDetailCountryName, tvDetailTotalCases, tvDetailTodayCases, tvDetailTotalDeaths,
            tvDetailTodayDeaths, tvDetailTotalRecovered, tvDetailTotalActive, tvDetailTotalCritical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_country_detail);



        // call view
        tvDetailCountryName = findViewById(R.id.detailCountryName);
        tvDetailTotalCases = findViewById(R.id.detailTotalCases);
        tvDetailTodayCases = findViewById(R.id.detailTodayCases);
        tvDetailTotalDeaths = findViewById(R.id.detailTotalDeaths);
        tvDetailTodayDeaths = findViewById(R.id.detailTodayDeaths);
        tvDetailTotalRecovered = findViewById(R.id.detailTotalRecovered);
        tvDetailTotalActive = findViewById(R.id.detailTotalActive);
        tvDetailTotalCritical = findViewById(R.id.detailTotalCritical);


        // call Covid Country
        CovidCountry covidCountry = getIntent().getParcelableExtra("EXTRA_COVID");

        // set text view
        tvDetailCountryName.setText(covidCountry.getmCovidCountry());
        tvDetailTotalCases.setText(Integer.toString(covidCountry.getmCases()));
        tvDetailTodayCases.setText(covidCountry.getmTodayCases());
        tvDetailTotalDeaths.setText(covidCountry.getmDeaths());
        tvDetailTodayDeaths.setText(covidCountry.getmTodayDeaths());
        tvDetailTotalRecovered.setText(covidCountry.getmRecovered());
        tvDetailTotalActive.setText(covidCountry.getmActive());
        tvDetailTotalCritical.setText(covidCountry.getmCritical());

    }
}