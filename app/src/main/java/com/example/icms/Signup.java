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
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Signup extends AppCompatActivity implements View.OnClickListener {
    Button signup_btn, signin_btn_on_signup;
    ProgressBar signup_progressbar;
    EditText signup_fullname_ET, signup_email_ET, signup_phone_ET, signup_password_ET, signup_confirmpassword_ET;
    FirebaseFirestore mFirestore;
    String userID;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.secondarytheme2));
        }

        mAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();
        signup_btn = findViewById(R.id.signup_btn);
        signin_btn_on_signup = findViewById(R.id.signin_button_onsignup_screen);
        signup_progressbar = findViewById(R.id.signup_progressbar);
        signup_fullname_ET = findViewById(R.id.signup_fullname_ET);
        signup_email_ET = findViewById(R.id.signup_email_ET);

        signup_phone_ET = findViewById(R.id.signup_phone_ET);
        signup_password_ET = findViewById(R.id.signup_password_ET);
        signup_confirmpassword_ET = findViewById(R.id.signup_confirmpassword_ET);

        signin_btn_on_signup.setOnClickListener(this);
        signup_btn.setOnClickListener(this);

        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signup_btn:
                registerUser();
                break;
            case R.id.signin_button_onsignup_screen:
                startActivity(new Intent(this, Login.class));
                finish();
                break;
        }
    }

    private void registerUser() {
        final String fullname = signup_fullname_ET.getText().toString().trim();
        final String email = signup_email_ET.getText().toString().trim();
        final String phone = signup_phone_ET.getText().toString().trim();

        String password = signup_password_ET.getText().toString().trim();
        String confirmpassword = signup_confirmpassword_ET.getText().toString().trim();

        if (fullname.isEmpty()) {
            signup_fullname_ET.setError("Username is required!");
            signup_fullname_ET.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            signup_email_ET.setError("Email is required!");
            signup_email_ET.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signup_email_ET.setError("Please provide valid email!");
            signup_email_ET.requestFocus();
            return;
        }

        if (phone.isEmpty()) {
            signup_phone_ET.setError("Phone is required!");
            signup_phone_ET.requestFocus();
            return;
        }
        if (phone.length() < 10) {
            signup_phone_ET.setError("Minimum phone number length should be 10 characters!");
            signup_phone_ET.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            signup_password_ET.setError("Password is required!");
            signup_password_ET.requestFocus();
            return;
        }

        if (password.length() < 6) {
            signup_password_ET.setError("Minimum password length should be 6 characters!");
            signup_password_ET.requestFocus();
            return;
        }
        if (confirmpassword.isEmpty()) {
            signup_confirmpassword_ET.setError("Password Confirmation is required!");
            signup_confirmpassword_ET.requestFocus();
            return;
        }
        if (!password.matches(confirmpassword)) {
            signup_confirmpassword_ET.setError("Password didn't match!");
            signup_confirmpassword_ET.requestFocus();
            return;
        }

        signup_progressbar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
//                    Users users=new Users(username,email);
                    Toast.makeText(Signup.this, "User Created.", Toast.LENGTH_SHORT).show();
                    userID = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();

                    DocumentReference documentReference = mFirestore.collection("users").document(userID);
                    Map<String, Object> user = new HashMap<>();
                    user.put("fullname", fullname);
                    user.put("email", email);
                    user.put("Phone", phone);

                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(Signup.this, "Success! profile is created for" + userID, Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Signup.this, "Error!" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });

                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();

                } else {
                    Toast.makeText(Signup.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    signup_progressbar.setVisibility(View.GONE);
                }
            }
        });
    }
}