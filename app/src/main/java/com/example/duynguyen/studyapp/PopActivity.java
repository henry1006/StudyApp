package com.example.duynguyen.studyapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

// Followed this tutorial - https://www.youtube.com/watch?v=eX-TdY6bLdg
public class PopActivity extends Activity {

    Button btn_in;
    Button btn_out;

    //Hard-coded values
    private int max_capacity = 24;
    private int curr_capacity = 0;

    TextView Capacity_tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        Capacity_tx = (TextView) findViewById(R.id.Capacity);

        btn_in = (Button) findViewById(R.id.btn_in);
        btn_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr_capacity++;
                Capacity_tx.setText(curr_capacity + "/" + max_capacity);
//                finish();
            }
        });

        btn_out = (Button) findViewById(R.id.btn_out);
        btn_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr_capacity--;
                Capacity_tx.setText(curr_capacity + "/" + max_capacity);
//                finish();
            }
        });

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.6 ), (int)(height*.5));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);
    }
}

//package com.example.duynguyen.studyapp;
//
//import android.app.Activity;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.DisplayMetrics;
//import android.view.Gravity;
//import android.view.WindowManager;
//
//public class PopActivity extends Activity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_pop);
//
//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//
//        int width = dm.widthPixels;
//        int height = dm.heightPixels;
//
//        getWindow().setLayout((int)(width*.6),(int)(height*.5));
//
//        WindowManager.LayoutParams params = getWindow().getAttributes();
//        params.gravity = Gravity.CENTER;
//        params.x = 0;
//        params.y = -20;
//
//        getWindow().setAttributes(params);
//
//    }
//}
