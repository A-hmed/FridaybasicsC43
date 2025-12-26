package com.route.androidbasicsfridayc43;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
//Git Servers: Github - Gitlab - BitBucket - Azure
/// Git Gui -> Android studio - Github desktop - Sourcetree - GitKraken
/// Git is a command line tool:
/// init: Create empty repo.
/// commit: Save current files into git
/// branch -
/// switch(checkout) -
/// merge -
/// reset -
/// rebase
/// reverse
/// cherry pick
/// Pull
/// push
/// fetch

public class MainActivity extends AppCompatActivity
{
    Button startMagazineBtn;
    Button startHomeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startMagazineBtn = findViewById(R.id.toMagazineButton);
        startHomeBtn = findViewById(R.id.toHomeButton);
        Log.e("MainActivity", "onCreate");
        startHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open gmail via Intent
            }
        });
        startMagazineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent explicitIntent = new Intent(MainActivity.this, MagazineActivity.class);
                startActivity(explicitIntent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MainActivity", "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MainActivity", "onDestroy");
    }
}

/// Activity - Service - Broadcast Receiver - Content Provider

/// Intent