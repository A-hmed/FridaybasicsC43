package com.route.androidbasicsfridayc43;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class XOGameIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xogame_intro);
    }

    public void onPickerClick(View v){
        Intent intent = new Intent(this, GameBoardActivity.class);
        TextView clickContainer = (TextView) v;
        intent.putExtra(GameBoardActivity.FIRST_PLAYER, clickContainer.getText().toString());
        startActivity(intent);
    }
}