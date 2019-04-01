package com.example.greenmario;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.List;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText email, password, passwordConfirm;
    private ImageView emailJudgment, passwordJudgment, confirmJudgment;
    private boolean emailValid = false, passwordValid = false, confirmValid = false;
    private Drawable tick, cross;
    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        findViewById(R.id.btn_back_create).setOnClickListener(view -> finish());

        email = findViewById(R.id.et_email_create);
        password = findViewById(R.id.et_password_create);
        passwordConfirm = findViewById(R.id.et_password_confirm_create);
        emailJudgment = findViewById(R.id.iv_email_judgment_create);
        passwordJudgment = findViewById(R.id.iv_password_judgment_create);
        confirmJudgment = findViewById(R.id.iv_password_confirm_judgment_create);
        tick = getResources().getDrawable(R.drawable.tick);
        cross = getResources().getDrawable(R.drawable.cross);
        nextBtn = findViewById(R.id.btn_next_create);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString();
                if (str.isEmpty()) {
                    emailValid = false;
                    emailJudgment.setVisibility(View.INVISIBLE);
                } else if (validateEmailAddress(str)) {
                    emailValid = true;
                    emailJudgment.setVisibility(View.VISIBLE);
                    emailJudgment.setImageDrawable(tick);
                } else {
                    emailValid = false;
                    emailJudgment.setVisibility(View.VISIBLE);
                    emailJudgment.setImageDrawable(cross);
                }

                updateNextButton();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString();
                if (str.isEmpty()) {
                    passwordValid = false;
                    passwordJudgment.setVisibility(View.INVISIBLE);
                } else if (validatePassword(str)) {
                    passwordValid = true;
                    passwordJudgment.setVisibility(View.VISIBLE);
                    passwordJudgment.setImageDrawable(tick);
                } else {
                    passwordValid = false;
                    passwordJudgment.setVisibility(View.VISIBLE);
                    passwordJudgment.setImageDrawable(cross);
                }

                updateNextButton();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        passwordConfirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString();
                if (str.isEmpty()) {
                    confirmValid = false;
                    confirmJudgment.setVisibility(View.INVISIBLE);
                } else if (validatePasswordConfirmation(str)) {
                    confirmValid = true;
                    confirmJudgment.setVisibility(View.VISIBLE);
                    confirmJudgment.setImageDrawable(tick);
                } else {
                    confirmValid = false;
                    confirmJudgment.setVisibility(View.VISIBLE);
                    confirmJudgment.setImageDrawable(cross);
                }

                updateNextButton();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        nextBtn.setOnClickListener(view -> proceedToDetails());
    }

    private boolean validateEmailAddress(String email) {
        return email.matches(
                "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|" +
                        "(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
    }

    private static boolean validatePassword(String password) {
        return password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$");
    }

    private boolean validatePasswordConfirmation(String confirmation) {
        return confirmation.equals(password.getText().toString());
    }

    private void updateNextButton() {
        nextBtn.setEnabled(emailValid && passwordValid && confirmValid);
    }

    private void proceedToDetails() {
        Intent intent = new Intent();
        intent.setClass(this, EnterDetailsActivity.class);

        intent.putExtra("email", email.getText().toString());

        startActivity(intent);
    }
}
