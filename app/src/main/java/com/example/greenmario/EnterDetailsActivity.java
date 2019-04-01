package com.example.greenmario;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class EnterDetailsActivity extends AppCompatActivity {

    EditText name, username, age, birthDate, address;
    RadioGroup rg;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_details);

        findViewById(R.id.btn_save_details).setOnClickListener(view -> saveAndProceed());

        name = findViewById(R.id.et_name_details);
        username = findViewById(R.id.et_username_details);
        age = findViewById(R.id.et_age_details);
        birthDate = findViewById(R.id.et_birth_date_details);
        address = findViewById(R.id.et_address_details);

        rg = findViewById(R.id.rg_gender_details);

        email = getIntent().getStringExtra("email");
    }

    private void saveAndProceed() {
        Profile p = new Profile();

        p.email = email;
        p.name = name.getText().toString();
        p.username = username.getText().toString();
        if (!age.getText().toString().isEmpty()) {
            p.age = Integer.parseInt(age.getText().toString());
        }
        p.birthDate = birthDate.getText().toString();

        RadioButton rb = rg.findViewById(rg.getCheckedRadioButtonId());
        p.gender = rb.getText().toString();
        p.address = address.getText().toString();
        p.country = "USA";

        Intent intent = new Intent();
        intent.setClass(this, ViewResultsActivity.class);

        intent.putExtra("profile", p);

        startActivity(intent);
    }
}
