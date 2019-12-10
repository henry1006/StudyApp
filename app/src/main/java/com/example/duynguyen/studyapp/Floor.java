/*package com.example.duynguyen.studyapp;

import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Floor extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_floor);
    }
}
 */
package com.example.duynguyen.studyapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

//https://www.youtube.com/watch?v=wfADRuyul04 //link to how this works

public class Floor extends AppCompatActivity {
    Button button;
    Button button2;
    TextView itemSelected;
    String[] listItems;
    boolean[] checkedItems;
    ArrayList<Integer> userItems = new ArrayList<>(); //items checked
    private RecyclerView cities;
    private RecyclerView.Adapter adapter;
    private Intent intent;
    //private ArrayList<City> cities2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_floor);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);

        itemSelected = (TextView) findViewById(R.id.tv);
        listItems = getResources().getStringArray(R.array.features);
        checkedItems = new boolean[listItems.length];

        //LIST
        final ArrayList<City> cities = initCities();
        //cities2 = cities;
        List(cities);


        //END OF LIST

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMaps();
            }
        });


        //FILTER
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCheckin();
            }
        });
    }
    public void openMaps() {
        Intent intent = new Intent(this, Page2.class);
        startActivity(intent);
    }
    public void openCheckin() {
        Intent intent = new Intent(this, Fcheckin.class);
        startActivity(intent);
    }

    //List function
    public void List(ArrayList<City> cities){
        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        this.cities = (RecyclerView) findViewById(R.id.cities);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        this.cities.setLayoutManager(mLayoutManager);

        adapter = new CityAdapter(cities);
        this.cities.setAdapter(adapter);
    }

    private ArrayList<City> initCities() {
        ArrayList<City> list = new ArrayList<>();

     //   list.add(new City("Dubois LLC", "Loud. Printer. Computer. Bathroom", "https://www.library.umass.edu/assets/Uploads/_resampled/ResizedImageWzYwMCwyNjFd/gradwide800.jpg"));
     //   list.add(new City("Dubois Cafe", "Loud. Food. Drink. Bright Light", "https://umassdining.com/sites/default/files/images/procrastination_station%20_resized.jpg"));
        list.add(new City("Dubois 23rd Floor", "Quiet. Dim Light. Outlet. Study Materials", "https://amherstwire.com/wp-content/uploads/2019/03/6OqAdPo2RyKaZ7lRp0i49w_thumb_6a23.jpg"));

        SharedPreferences pref = getApplicationContext().getSharedPreferences("My", 0); // 0 - for private mode
       TextView busy = (TextView) findViewById(R.id.busy);
        busy.setText(pref.getString("Floor", ""));




        return list;
    }
}

