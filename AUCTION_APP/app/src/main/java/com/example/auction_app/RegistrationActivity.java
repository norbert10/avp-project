package com.example.auction_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //to hide action bar
        getSupportActionBar().hide();
    }

    public void goRegister(final View register){
        Intent reg = new Intent(this, MainActivity.class);
        startActivity(reg);
        Toast.makeText(RegistrationActivity.this, "Registered", Toast.LENGTH_SHORT).show();
    }

    public void hasAccount(final View account){
        Intent acc = new Intent(this, MainActivity.class);
        startActivity(acc);
    }
}