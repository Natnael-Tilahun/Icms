package com.example.icms;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button signin_btn, signup_btn_on_signin, forgetpassword_on_signin;
    EditText login_password_ET, login_email_ET;
    ProgressBar login_progressbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.secondarytheme2));
        }
        signin_btn = findViewById(R.id.signin_btn);
        signup_btn_on_signin = findViewById(R.id.signup_button_signin_screen);
        forgetpassword_on_signin = findViewById(R.id.forgetpassword_button_signin_screen);
//        login_username_ET=findViewById(R.id.login_username_ET);
        login_email_ET = findViewById(R.id.login_email_ET);
        login_password_ET = findViewById(R.id.login_password_ET);
        login_progressbar = findViewById(R.id.login_progressbar);
        mAuth = FirebaseAuth.getInstance();

        signin_btn.setOnClickListener(this);
        signup_btn_on_signin.setOnClickListener(this);
        forgetpassword_on_signin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signin_btn:
                signin();
                break;
            case R.id.signup_button_signin_screen:
                startActivity(new Intent(this, Signup.class));
                finish();
                break;
            case R.id.forgetpassword_button_signin_screen:
                startActivity(new Intent(Login.this, ForgetPassword.class));
                finish();
                break;
        }
    }

    private void signin() {
        String email = login_email_ET.getText().toString().trim();
        String password = login_password_ET.getText().toString().trim();

        if (email.isEmpty()) {
            login_email_ET.setError("Username is required!");
            login_email_ET.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            login_email_ET.setError("Please provide valid email!");
            login_email_ET.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            login_password_ET.setError("Password is required!");
            login_password_ET.requestFocus();
            return;
        }
        if (password.length() < 6) {
            login_password_ET.setError("Minimum password length should be 6 characters!");
            login_password_ET.requestFocus();
            return;
        }

        login_progressbar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Login.this, "Logged Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(Login.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    login_progressbar.setVisibility(View.GONE);
                }
            }
        });
    }
}