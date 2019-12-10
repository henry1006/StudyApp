package com.example.duynguyen.studyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("My", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("LLC", "not busy right now");
        editor.putString("Floor", "not busy right now");
        editor.putString("Cafe", "not busy right now");

        editor.commit();
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });


    }

    public void openActivity2() {
        Intent intent = new Intent(this, Page2.class);
        startActivity(intent);
    }
}