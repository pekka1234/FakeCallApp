package com.example.fakecallpropremiumfree;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.io.*;
import java.util.*;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void random(View view) {
        switch_activity(SecondActivity.class);
    }

    public void selected(View view) {
        switch_activity(FourthActivity.class);
    }
    // Switching to call screen or the call settings screen
    private void switch_activity(Class activity){
        android.content.Intent intent = new android.content.Intent(this, activity);
        startActivity(intent);
    }


}