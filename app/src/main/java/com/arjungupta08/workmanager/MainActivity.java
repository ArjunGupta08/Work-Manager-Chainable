package com.arjungupta08.workmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OneTimeWorkRequest oneTimeWorkRequest1 = new OneTimeWorkRequest.Builder(WorkA.class).build();
        OneTimeWorkRequest oneTimeWorkRequest2 = new OneTimeWorkRequest.Builder(WorkB.class).build();
        OneTimeWorkRequest oneTimeWorkRequest3 = new OneTimeWorkRequest.Builder(WorkC.class).build();

        WorkManager.getInstance(this)
                .beginWith(oneTimeWorkRequest1)
                .then(oneTimeWorkRequest2)
                .then(oneTimeWorkRequest3)
                .enqueue();
    }
}