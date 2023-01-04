package com.example.fakecallpropremiumfree;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import java.io.*;
import java.util.*;
import android.os.Environment;
import android.content.Intent;
import android.provider.Settings;
import android.net.Uri;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {
    String path = "none";
    MediaPlayer player = new MediaPlayer();
    public String name;
    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extras = getIntent().getExtras();
        String random_name;
        TextView theTextView = (TextView) findViewById(R.id.textView2);
        // If user hasn't set callers name, it will be random:
        if (extras != null) {
            random_name = extras.getString("name_user_set");
        }else{
            ArrayList<String> nimet = new ArrayList<>(Arrays.asList("Andrew", "Thomas", "George", "James", "Oliver", "Jack", "Oscar", "William"));
            Random r = new Random();
            random_name = nimet.get(r.nextInt(nimet.size()));

        }
        name = random_name;
        theTextView.setText(random_name);

        // Playing phone call sound
        int ringtone = 0;
        if(extras == null) {
            player = MediaPlayer.create(this, R.raw.ring);
            player.start();
        }
        else {
            ringtone = extras.getInt("ringtone");
            if (ringtone == 0) {
                player = MediaPlayer.create(this, R.raw.ring);
                player.start();
            } else if (ringtone == 1) {
                player = MediaPlayer.create(this, R.raw.huawei);
                player.start();
            } else if (ringtone == 2) {
                player = MediaPlayer.create(this, R.raw.nokia);
                player.start();
            } else if (ringtone == 3) {
                player = MediaPlayer.create(this, R.raw.marimba);
                player.start();
            }
        }
    }
    // accepting call
    public void accept(View view){
        audio_off();
        android.content.Intent intent = new android.content.Intent(this, ThirdActivity.class);
        intent.putExtra("name",name);
        startActivity(intent);
    }
   // declining call
    public void decline(View view){
        audio_off();
        android.content.Intent intent = new android.content.Intent(this, MainActivity.class);
        startActivity(intent);
    }
    // turning off phone call sound
    private void audio_off(){
        if (player != null && player.isPlaying()) {
            player.stop();
            player.release();
            player = null;
        }
    }


}