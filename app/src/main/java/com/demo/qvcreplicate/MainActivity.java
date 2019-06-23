package com.demo.qvcreplicate;

import android.content.Intent;
import android.content.SharedPreferences;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final int USER_AGREEMENT = 1;

    public static final String TAG = "STATUSCHECK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences userSession = getSharedPreferences("firstTime", MODE_PRIVATE);
        if(userSession.getBoolean("firstTime", true)){
            Log.i(TAG, "onCreate: first time user is entering screen; true");
            Intent userAgreement = new Intent(MainActivity.this, UserAgreement.class);
            startActivityForResult(userAgreement, USER_AGREEMENT);
        } else {
            Log.i(TAG, "onCreate: firstTime : false");
            Intent mainNav = new Intent(MainActivity.this, MainNavigation.class);
            startActivity(mainNav);
        }

        Log.i(TAG, "onCreate: firstTime: undetermined");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == USER_AGREEMENT){
            //check if user has agreed to the terms
            if (resultCode == RESULT_OK){
                Log.i(TAG, "onActivityResult: back to MainActivity. userAgreement Accepted");
                SharedPreferences userSession = getSharedPreferences("firstTime", MODE_PRIVATE);
                SharedPreferences.Editor editor = getSharedPreferences("firstTime", MODE_PRIVATE).edit();
                editor.putBoolean("firstTime", false);
                editor.apply();;
                Intent mainNav = new Intent(MainActivity.this, MainNavigation.class);
                startActivity(mainNav);
            } else if (resultCode == RESULT_CANCELED){
                //usre has declined the terms of agreement
                finish();
            } else {
                Log.i(TAG, "onActivityResult: neither accepted or declined user agreement");
            }
        }
    }
}
