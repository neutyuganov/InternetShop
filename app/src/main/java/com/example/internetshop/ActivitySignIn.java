package com.example.internetshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivitySignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void clickGoSignUp(View view){
        Intent intent = new Intent(getApplicationContext(),ActivitySignUp.class);
        startActivity(intent);
        finish();
    }

    public void clickSignIn(View view){
        Intent intent = new Intent(getApplicationContext(),ActivityMenu.class);
        startActivity(intent);
        finishAffinity();
    }

}