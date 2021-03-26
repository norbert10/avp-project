package com.example.auction_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public  void goBack(final View v){
        Intent back = new Intent(this, MainActivity.class);
        startActivity(back);
    }
    public void goToDecisionPage(final View view){
        Intent decisionPage = new Intent(this, MainActivityDecision.class);
        startActivity(decisionPage);
    }


    public void itemDetails(final View v){
        Intent intent = new Intent(this, ProductDetails.class );
        startActivity(intent);
    }

    public void helpDesk(final View help){
        Intent helper = new Intent(this, ContactDetails.class);
        startActivity(helper);
    }
}