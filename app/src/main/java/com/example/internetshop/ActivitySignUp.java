package com.example.internetshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivitySignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void clickGoSignIn(View view){
        Intent intent = new Intent(getApplicationContext(),ActivitySignIn.class);
        startActivity(intent);
        finish();
    }

}