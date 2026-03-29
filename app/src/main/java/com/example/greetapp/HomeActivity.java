package com.example.greetapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    TextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        welcomeText = findViewById(R.id.welcomeText);

        // Get saved data
        SharedPreferences sp = getSharedPreferences("UserData", MODE_PRIVATE);
        String name = sp.getString("username", "User");

        // Show in TextView
        welcomeText.setText("Hello " + name);

        // Also show Toast
        Toast.makeText(this, "Welcome " + name, Toast.LENGTH_LONG).show();
    }
}