package com.example.duynguyen.studyapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.TextView;

import java.util.ArrayList;

//https://www.youtube.com/watch?v=wfADRuyul04 //link to how this works

public class Page2 extends AppCompatActivity {
    Button button;
    Button button2;
    Button button7;
    Button button8;
    Button button9;
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
        setContentView(R.layout.activity_main2);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);

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
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLLC();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCafe();
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFloor();
            }
        });


        //FILTER
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(com.example.duynguyen.studyapp.Page2.this);
                builder.setTitle("Features");
                builder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
                        if (isChecked) {
                            userItems.add(i);
                        } else {
                            userItems.remove(i);
                        }
                    }
                });

                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0; i < userItems.size(); i++) {
                            item = item + listItems[userItems.get(i)];
                            if(i != userItems.size() -1) {
                                item = item+", ";
                            }
                        }
//                        itemSelected.setText(item); //This line prints the selected checkboxes.(in the middle)
                        String str[] = item.split(", "); //every filter selection
                        ArrayList<City> cities2 = new ArrayList<City>();

                        for(int i = 0; i < cities.size(); i++) {
                            for (int j = 0; j < str.length; j++){
                                if (!cities2.contains(cities.get(i))){
                                    if (cities.get(i).getDescription().contains(str[j])){
                                        cities2.add(cities.get(i));
                                    }
                                }
                            }
                        }

                        List(cities2);
                        int llc_number=5;
                        int cafe_number=5;
                        int floor_number=5;

                        for(int i = 0; i < cities2.size(); i++) {
                            if(cities2.get(i).getName()=="Dubois LLC"){
                                llc_number=i;//250 550 850
                                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)button7.getLayoutParams();
                                params.setMargins(0, (250+(300*i)), 10, 0); //substitute parameters for left, top, right, bottom
                                button7.setLayoutParams(params);
                            }
                            if(cities2.get(i).getName()=="Dubois Cafe"){
                                cafe_number=i;
                                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)button8.getLayoutParams();
                                params.setMargins(0, (250+(300*i)), 10, 0); //substitute parameters for left, top, right, bottom
                                button8.setLayoutParams(params);
                            }
                            if(cities2.get(i).getName()=="Dubois 23rd Floor"){
                                   floor_number=i;
                                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)button9.getLayoutParams();
                                params.setMargins(0, (250+(300*i)), 10, 0); //substitute parameters for left, top, right, bottom
                                button9.setLayoutParams(params);
                            }

                        }
                        if(llc_number==5){
                            button7.setVisibility(View.GONE);
                        }
                        else{
                            button7.setVisibility(View.VISIBLE);
                        }
                        if(cafe_number==5){
                            button8.setVisibility(View.GONE);
                        }
                        else{
                            button8.setVisibility(View.VISIBLE);
                        }
                        if(floor_number==5){
                            button9.setVisibility(View.GONE);
                        }
                        else{
                            button9.setVisibility(View.VISIBLE);
                        }




                        //Show cities2. (?)

                    }
                });

                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                builder.setNeutralButton("Clear all", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        for (int i = 0; i < checkedItems.length; i++) {
                            checkedItems[i] = false;
                            userItems.clear();
                            itemSelected.setText("");
                        }
                        List(cities);
                        int llc_number=5;
                        int cafe_number=5;
                        int floor_number=5;

                        for(int i = 0; i < cities.size(); i++) {
                            if(cities.get(i).getName()=="Dubois LLC"){
                                llc_number=i;//250 550 850
                                //button7.layout(0,(int) (250+(300*i)),0,0);
                                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)button7.getLayoutParams();
                                params.setMargins(0, (250+(300*i)), 10, 0); //substitute parameters for left, top, right, bottom
                                button7.setLayoutParams(params);
                            }
                            if(cities.get(i).getName()=="Dubois Cafe"){
                                cafe_number=i;
                                //button8.layout(0,(int) (250+(300*i)),0,0);
                                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)button8.getLayoutParams();
                                params.setMargins(0, (250+(300*i)), 10, 0); //substitute parameters for left, top, right, bottom
                                button8.setLayoutParams(params);
                            }
                            if(cities.get(i).getName()=="Dubois 23rd Floor"){
                                floor_number=i;
                               // button9.layout(0,(int) (250+(300*i)),0,0);
                                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)button9.getLayoutParams();
                                params.setMargins(0, (250+(300*i)), 10, 0); //substitute parameters for left, top, right, bottom
                                button9.setLayoutParams(params);
                            }

                        }
                        if(llc_number==5){
                            button7.setVisibility(View.GONE);
                        }
                        else{
                            button7.setVisibility(View.VISIBLE);
                        }
                        if(cafe_number==5){
                            button8.setVisibility(View.GONE);
                        }
                        else{
                            button8.setVisibility(View.VISIBLE);
                        }
                        if(floor_number==5){
                            button9.setVisibility(View.GONE);
                        }
                        else{
                            button9.setVisibility(View.VISIBLE);
                        }
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }

        });
    }
    public void openMaps() {
        Intent intent = new Intent(this, Maps.class);
        startActivity(intent);
    }
    public void openLLC() {
        Intent intent = new Intent(this, LLC.class);
        startActivity(intent);
    }
    public void openCafe() {
        Intent intent = new Intent(this, Cafe.class);
        startActivity(intent);
    }
    public void openFloor() {
        Intent intent = new Intent(this, Floor.class);
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
       //
        list.add(new City("Dubois LLC", "Loud. Printer. Computer. Bathroom", "https://www.library.umass.edu/assets/Uploads/_resampled/ResizedImageWzYwMCwyNjFd/gradwide800.jpg"));
      //  RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.item_city);
      //  remoteViews.setTextViewText(R.id.button6, "Set button text here");

        list.add(new City("Dubois Cafe", "Loud. Food. Drink. Bright Light", "https://umassdining.com/sites/default/files/images/procrastination_station%20_resized.jpg"));
     //    p1_button = (Button)findViewById(R.id.button6);

   //     p1_button.setText("OpenLLC");
        list.add(new City("Dubois 23rd Floor", "Quiet. Dim Light. Outlet. Study Materials", "https://amherstwire.com/wp-content/uploads/2019/03/6OqAdPo2RyKaZ7lRp0i49w_thumb_6a23.jpg"));


        return list;
    }

}