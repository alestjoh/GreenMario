package com.example.greenmario;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class LandingActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        btn = findViewById(R.id.btn_create_account_landing);
        btn.setOnClickListener(view -> moveToCreateAccount());

    }


    private void moveToCreateAccount() {
        Intent intent = new Intent();
        intent.setClass(this, CreateAccountActivity.class);

        startActivity(intent);
    }
}
