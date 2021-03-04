package com.gyamfimartins.sportsresults.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.ProgressBar;

import com.gyamfimartins.sportsresults.R;


public class MainActivity extends AppCompatActivity {
    private ProgressBar progress_circular;
    private Button btn_loaddata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress_circular = findViewById(R.id.progress_circular);

        btn_loaddata = findViewById(R.id.btn_loaddata);
        btn_loaddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delay();
            }
        });

    }


    private void delay() {
        btn_loaddata.setVisibility(View.GONE);
        progress_circular.setVisibility(View.VISIBLE);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, DisplayDataActivity.class));
                finish();
            }
        }, 3000);
    }





}