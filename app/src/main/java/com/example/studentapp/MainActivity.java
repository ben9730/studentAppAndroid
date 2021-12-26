package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //NavController in the code
    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //the navHost in the onCrate of our main activity
        NavHost navHost = (NavHost) getSupportFragmentManager().findFragmentById(R.id.main_navhost_fragmentContainerView);
        navController = navHost.getNavController();

    }
}