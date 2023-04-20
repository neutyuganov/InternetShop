package com.example.internetshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivitySignIn extends AppCompatActivity {
    EditText editTextTextEmailAdress, editTextTextPassword;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        editTextTextEmailAdress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        preferences = getSharedPreferences("UserInfo", 0);
    }

    public void clickGoSignUp(View view){
        Intent intent = new Intent(getApplicationContext(),ActivitySignUp.class);
        startActivity(intent);
        finish();
    }

    public void clickSignIn(View view){
        String passwordValue = editTextTextPassword.getText().toString();
        String emailValue = editTextTextEmailAdress.getText().toString();
        String registeredEmail = preferences.getString("email","");
        String registeredPassword = preferences.getString("password", "");

        if (passwordValue.equals(registeredPassword)&&emailValue.equals(registeredEmail)) {
            Intent i = new Intent(ActivitySignIn.this, ActivityMenu.class);
            startActivity(i);
        }
        else {
            Toast.makeText(ActivitySignIn.this , "Неверные данные", Toast.LENGTH_SHORT).show();
        }
    }

}