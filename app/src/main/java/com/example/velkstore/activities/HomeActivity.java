package com.example.velkstore.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.velkstore.R;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    ProgressBar progressBar;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        auth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);

        }

    public void Login(View view) {
        startActivity(new Intent(HomeActivity.this, LoginActivity.class));
    }

    public void Registration(View view) {
        startActivity(new Intent(HomeActivity.this, RegistrationActivity.class));
    }
}
