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

import java.util.ArrayList;

//https://www.youtube.com/watch?v=wfADRuyul04 //link to how this works

public class Ccheckin extends AppCompatActivity {
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
        setContentView(R.layout.checkin_cafe);

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

                editor.putString("Cafe",          (String) button1.getText());
                editor.commit();

                openMaps();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("My", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("Cafe",          (String) button2.getText());
                editor.commit();

                openMaps();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("My", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("Cafe",          (String) button3.getText());
                editor.commit();

                openMaps();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("My", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("Cafe",          (String) button4.getText());
                editor.commit();

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

