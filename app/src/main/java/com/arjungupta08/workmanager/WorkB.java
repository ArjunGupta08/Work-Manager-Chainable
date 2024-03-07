package com.arjungupta08.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class WorkB extends Worker {
    private static final String TAG = "WorkB";
    public WorkB(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.d(TAG, "Work B Started");
        try {
            Thread.sleep(2000);
            Log.d(TAG, "WorkB Done");
            return Result.success();
        } catch (Exception e) {
            System.out.println(e.toString());
            return Result.failure();
        }
    }
}