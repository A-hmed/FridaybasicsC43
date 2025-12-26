package com.route.androidbasicsfridayc43;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MagazineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazine);
        Log.w("MagazineActivity", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MagazineActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MagazineActivity", "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MagazineActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MagazineActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MagazineActivity", "onDestroy");
    }
}
