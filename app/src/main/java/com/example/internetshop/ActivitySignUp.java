package com.example.internetshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ActivitySignUp extends AppCompatActivity {
EditText editTextTextF, editTextTextI, editTextTextEmailAdress, editTextTextPassword, editTextTextPasswordR;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        editTextTextF = findViewById(R.id.editTextTextF);
        editTextTextI = findViewById(R.id.editTextTextI);
        editTextTextEmailAdress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        editTextTextPasswordR = findViewById(R.id.editTextTextPasswordR);
        preferences = getSharedPreferences("UserInfo", 0);
    }

    public void clickGoSignIn(View view){
        Intent intent = new Intent(getApplicationContext(),ActivitySignIn.class);
        startActivity(intent);
        finish();
    }

    public void clickSignUp(View view){

        String emailValue = editTextTextEmailAdress.getText().toString();
        String passwordValue = editTextTextPassword.getText().toString();
        String passwordValueR = editTextTextPasswordR.getText().toString();
        String emailPattern = "[a-zA-Z0-9._]+@[a-z]+\\.+[a-z]+";

        if ((passwordValue.equals(passwordValueR))&&(passwordValue.length() >= 8) && (emailValue.matches(emailPattern)) ) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("email", emailValue);
            editor.putString("password", passwordValue);
            editor.apply();
            Toast.makeText(ActivitySignUp.this , "Успешно!", Toast.LENGTH_SHORT).show();


            Intent intent = new Intent(ActivitySignUp.this , ActivityMenu.class);
            startActivity(intent);
        }
        else if(passwordValue.length()<8) {
            Toast.makeText(ActivitySignUp.this , "Создайте новый пароль (минимально - 8 символов)", Toast.LENGTH_SHORT).show();
        }
        else if(!(passwordValue.equals(passwordValueR))){
            Toast.makeText(ActivitySignUp.this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
        }
        else if (!emailValue.matches(emailPattern)) {
            Toast.makeText(ActivitySignUp.this , "Неверный E-mail", Toast.LENGTH_SHORT).show();
        }


    }

}