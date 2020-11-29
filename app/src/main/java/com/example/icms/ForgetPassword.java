package com.example.icms;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity implements View.OnClickListener {
    EditText forgetpassword_email_ET;
    ProgressBar forgetpassword_progresssbar;
    Button reset_btn;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        forgetpassword_email_ET = findViewById(R.id.foretpassword_email_ET);
        forgetpassword_progresssbar = findViewById(R.id.forgetpassword_progressbar);
        reset_btn = findViewById(R.id.reset_btn);
        mAuth = FirebaseAuth.getInstance();

        reset_btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.reset_btn:
                reset();
        }
    }

    private void reset() {
        String email = forgetpassword_email_ET.getText().toString().trim();

        if (email.isEmpty()) {
            forgetpassword_email_ET.setError("Email is required!");
            forgetpassword_email_ET.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            forgetpassword_email_ET.setError("Please provide valid email!");
            forgetpassword_email_ET.requestFocus();
            return;
        }
        forgetpassword_progresssbar.setVisibility(View.VISIBLE);
        mAuth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(ForgetPassword.this, "Reset link sent to your Email.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ForgetPassword.this, Login.class));
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ForgetPassword.this, "Error! Reset link is not sent" + e.getMessage(), Toast.LENGTH_SHORT).show();
                forgetpassword_progresssbar.setVisibility(View.GONE);
            }
        });

    }
}