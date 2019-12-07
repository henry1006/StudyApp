package com.example.duynguyen.studyapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.duynguyen.studyapp.R;

public class Page2 extends AppCompatActivity {

    private Context mContext;
    private Activity mActivity;

    private RelativeLayout mRelativeLayout;
    private TextView mTextView;
    private Toolbar mToolbar;

    private boolean mBold = false;
    private boolean mItalic = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the application context
        mContext = getApplicationContext();
        // Get the activity
        mActivity = Page2.this;

        // Get the widgets reference from XML layout
        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl);
        mTextView = (TextView) findViewById(R.id.tv);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        // Set a title for toolbar
        mToolbar.setTitle("Android Options Menu CheckBox");
        mToolbar.setTitleTextColor(Color.WHITE);

        // Set support actionbar with toolbar
        setSupportActionBar(mToolbar);

        // Change the toolbar background color
        mToolbar.setBackgroundColor(Color.parseColor("#FFF18BB7"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.filter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.bold:
                if(item.isChecked()){
                    // If item already checked then unchecked it
                    item.setChecked(false);
                    mBold = false;
                }else{
                    // If item is unchecked then checked it
                    item.setChecked(true);
                    mBold = true;
                }
                // Update the text view text style
                updateTextView();
                return true;
            case R.id.italic:
                if(item.isChecked()){
                    // If item already checked then unchecked it
                    item.setChecked(false);
                    mItalic = false;
                }else {
                    // If item is unchecked then checked it
                    item.setChecked(true);
                    mItalic = true;
                }
                // Update the text view text style
                updateTextView();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Custom method to update the text view text style
    protected void updateTextView(){
        if(mBold && mItalic){
            mTextView.setTypeface(null, Typeface.BOLD_ITALIC);
        }else if(mBold && !mItalic){
            mTextView.setTypeface(null,Typeface.BOLD);
        }else if(!mBold && mItalic){
            mTextView.setTypeface(null,Typeface.ITALIC);
        }else {
            mTextView.setTypeface(null,Typeface.NORMAL);
        }
    }
}
