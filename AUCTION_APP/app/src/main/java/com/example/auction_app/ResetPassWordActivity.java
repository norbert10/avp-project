package com.example.auction_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ResetPassWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass_word);
        //to hide action bar
        getSupportActionBar().hide();
    }

    public  void backToMain(final View fromReset){
        Intent fromRes = new Intent(this, MainActivity.class);
        startActivity(fromRes);
    }
}