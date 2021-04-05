package com.example.auction_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    EditText userName, emailAddress, password, phoneNumber;
    Button registration;
    TextView mLogin;
    FirebaseAuth fAuth;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //to hide action bar
        getSupportActionBar().hide();
        userName = findViewById(R.id.userName);
        emailAddress = findViewById(R.id.emailAddress);
        registration = findViewById(R.id.regButton);
        phoneNumber = findViewById(R.id.phoneNo);
        password = findViewById(R.id.myPassword);
        mLogin = findViewById(R.id.loginReg);
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailAddress.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    emailAddress.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    password.setError("Password is required");
                    return;
                }
                if(pass.length()< 6){
                    password.setError("Password must be more than 6 characters");
                    return;
                }
                //register the user in firebase
                fAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegistrationActivity.this, "User created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivityDecision.class));
                        }
                        else{
                            Toast.makeText(RegistrationActivity.this, "Error! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    public void goRegister(final View register){
        Intent reg = new Intent(this, Logout.class);
        startActivity(reg);
        Toast.makeText(RegistrationActivity.this, "Registered", Toast.LENGTH_SHORT).show();
    }

    public void hasAccount(final View account){
        Intent acc = new Intent(this, MainActivity.class);
        startActivity(acc);
    }
}