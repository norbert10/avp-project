package com.example.auction_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //to hide action bar
        getSupportActionBar().hide();

        textView1 = (TextView)findViewById(R.id.forgotPassword);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reset = new Intent(MainActivity.this, ResetPassWordActivity.class);
                startActivity(reset);
            }
        });

       textView = (TextView)findViewById(R.id.textView2);
       textView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent registration = new Intent(MainActivity.this, RegistrationActivity.class);
               startActivity(registration);
               Toast.makeText(MainActivity.this, "Register Here",Toast.LENGTH_SHORT).show();
           }
       });
    }
    public void goNext(final View v){
        Intent next = new Intent(this, MainActivity2.class);
        startActivity(next);
    }

}