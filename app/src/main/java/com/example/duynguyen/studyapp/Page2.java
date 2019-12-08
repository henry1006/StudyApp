package com.example.duynguyen.studyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Page2 extends AppCompatActivity {

    private RecyclerView cities;
    private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ArrayList<City> cities = initCities();

        this.cities = (RecyclerView) findViewById(R.id.cities);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        this.cities.setLayoutManager(mLayoutManager);

        adapter = new CityAdapter(cities);
        this.cities.setAdapter(adapter);
    }

    private ArrayList<City> initCities() {
        ArrayList<City> list = new ArrayList<>();

        list.add(new City("Dubois LLC", "Loud. Printer. Computer. Toilet", "https://www.library.umass.edu/assets/Uploads/_resampled/ResizedImageWzYwMCwyNjFd/gradwide800.jpg"));
        list.add(new City("Dubois Cafe", "Loud. Food. Drink. Bright Light", "https://umassdining.com/sites/default/files/images/procrastination_station%20_resized.jpg"));
        list.add(new City("Dubois 23rd Floor", "Quiet. Dim Light. Outlet. Study Materials", "https://amherstwire.com/wp-content/uploads/2019/03/6OqAdPo2RyKaZ7lRp0i49w_thumb_6a23.jpg"));


        return list;
    }
}