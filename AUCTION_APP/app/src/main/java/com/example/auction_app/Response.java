package com.example.auction_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Response extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);
    }

    public void backToMain(final View view){
        Intent intent = new Intent(this, MainActivityDecision.class);
        startActivity(intent);
    }
}