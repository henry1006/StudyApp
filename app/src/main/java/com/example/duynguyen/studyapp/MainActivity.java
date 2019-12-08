package com.example.duynguyen.studyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

//        //delete later
//        button = (Button) findViewById(R.id.button2);
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                openLocation1();
//            }
//        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Page2.class);
        startActivity(intent);
    }

    //delete later
//    public void openLocation1(){
//        Intent i = new Intent(this, Location1.class);
//        startActivity(i);
//    }

}
