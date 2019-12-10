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
    }d
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
import android.widget.Toast;

import java.util.ArrayList;

//https://www.youtube.com/watch?v=wfADRuyul04 //link to how this works

public class Fcheckin extends AppCompatActivity {
    Button button;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    TextView itemSelected;

    private Intent intent;
    //private ArrayList<City> cities2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkin_lower);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button1 = (Button) findViewById(R.id.button1);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("My", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();





        //END OF LIST
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                openMaps();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("My", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("Floor",          (String) button1.getText());
                editor.commit();
                Toast.makeText(getApplicationContext(),"We updated how busy your location is!",Toast.LENGTH_SHORT).show();

                openMaps();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("My", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("Floor",          (String) button2.getText());
                editor.commit();
                Toast.makeText(getApplicationContext(),"We updated how busy your location is!",Toast.LENGTH_SHORT).show();

                openMaps();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("My", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("Floor",          (String) button3.getText());
                editor.commit();
                Toast.makeText(getApplicationContext(),"We updated how busy your location is!",Toast.LENGTH_SHORT).show();

                openMaps();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("My", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("Floor",          (String) button4.getText());
                editor.commit();
                Toast.makeText(getApplicationContext(),"We updated how busy your location is!",Toast.LENGTH_SHORT).show();

                openMaps();
            }
        });



        //FILTER
    }
    public void openMaps() {
        Intent intent = new Intent(this, Page2.class);
        startActivity(intent);
    }


    //List function



}

