package com.example.greetapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(v -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();

            if(user.equals("admin") && pass.equals("1234")) {

                // Save data
                SharedPreferences sp = getSharedPreferences("UserData", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("username", user);
                editor.apply();

                // Move to Home
                startActivity(new Intent(this, HomeActivity.class));

            } else {
                Toast.makeText(this, "Invalid Login", Toast.LENGTH_SHORT).show();
            }
        });
    }
}