package com.example.fakecallpropremiumfree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import java.io.*;
import java.util.*;
public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Setting callers name to be displayed on the accepted call screen
        String name = "";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");
        }
        android.widget.TextView theTextView = (android.widget.TextView) findViewById(R.id.textView);
        theTextView.setText(name);
    }
}