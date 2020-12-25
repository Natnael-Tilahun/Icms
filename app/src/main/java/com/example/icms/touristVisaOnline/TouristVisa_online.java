package com.example.icms.touristVisaOnline;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TouristVisa_online extends AppCompatActivity {
    Spinner sp_TV_online;
    Button TV_online_next_btn;
    EditText TVonline_citizenship_ET;

    ProgressDialog mProgressDialog;
    FirebaseFirestore mFirestore;
    FirebaseAuth mFirebaseAuth;
    ArrayList<String> arrayList_TV_citizenship;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_visa_online);
        TV_online_next_btn = findViewById(R.id.TV_online_next_btn);
        TVonline_citizenship_ET = findViewById(R.id.TVonline_citizenship_ET);
        mProgressDialog = new ProgressDialog(TouristVisa_online.this);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();

        TV_online_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkform();
            }
        });
    }

    private void checkform() {
        String TVonline_citizenship = TVonline_citizenship_ET.getText().toString().trim();
        if (TVonline_citizenship.isEmpty()) {
            TVonline_citizenship_ET.setError("Please insert your CitizenShip!");
            TVonline_citizenship_ET.requestFocus();
        } else {
            addingDatasToFirestore();

        }
    }

    private void addingDatasToFirestore() {
        mProgressDialog.show();
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();
        String userID = (mFirebaseAuth.getCurrentUser()).getUid();
        String TVonline_citizenship = TVonline_citizenship_ET.getText().toString().trim();
        final DocumentReference documentReference = mFirestore.collection("users").document(userID);

        Map<String, String> userdata = new HashMap<>();
        //userdata.put("UserID", userID);
        userdata.put("Citizenship", TVonline_citizenship);
        mFirestore.collection("Service").document("Visa Service").collection("Tourist Visa Online").document(userID).set(userdata, SetOptions.merge()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(TouristVisa_online.this, "Document Successfully submitted", Toast.LENGTH_LONG).show();
                    //mProgressBar.setVisibility(View.GONE);
                    Intent intent = new Intent(TouristVisa_online.this, TV_onlineAppForm2.class);
                    startActivity(intent);
                    mProgressDialog.dismiss();

                } else {
                    Toast.makeText(TouristVisa_online.this, "Error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
