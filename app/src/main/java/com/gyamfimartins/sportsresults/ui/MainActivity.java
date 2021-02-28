package com.gyamfimartins.sportsresults.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.gyamfimartins.sportsresults.R;


public class MainActivity extends AppCompatActivity {

    private ProgressBar progress_circular;
    private int progressBarStatus = 0;
    private long fileSize = 0;
    private final Handler progressBarHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress_circular = findViewById(R.id.progress_circular);

        Button btn_loaddata = findViewById(R.id.btn_loaddata);
        btn_loaddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_loaddata.setVisibility(View.GONE);
                progress_circular.setVisibility(View.VISIBLE);
                showprogress();
            }
        });

    }


    private void showprogress() {
        new Thread(new Runnable() {
            public void run() {
                while (progressBarStatus < 100) {
                    progressBarStatus = doSomeTasks();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressBarHandler.post(new Runnable() {
                        public void run() {
                            progress_circular.setProgress(progressBarStatus);
                        }
                    });
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(MainActivity.this, DisplayDataActivity.class);
                startActivity(intent);
            }
        }).start();

    }


    public int doSomeTasks() {
        while (fileSize <= 1000000) {
            fileSize++;
            if (fileSize == 100000) {
                return 10;
            } else if (fileSize == 200000) {
                return 20;
            } else if (fileSize == 300000) {
                return 30;
            }
        }
        return 100;
    }


}