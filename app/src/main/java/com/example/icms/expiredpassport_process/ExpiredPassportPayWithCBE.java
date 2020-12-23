package com.example.icms.expiredpassport_process;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ExpiredPassportPayWithCBE extends AppCompatActivity {
    EditText expiredpasscbefullname_ET, expiredpasscberecipentaccno_ET, expiredpasscbeamount_ET;
    TextView paymentinstruction;
    Button expiredpasspay_btn;
    FirebaseFirestore mFirebaseFirestore;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expired_passport_pay_with_c_b_e);
        expiredpasscbefullname_ET = findViewById(R.id.expiredpasscbefullname_ET);
        expiredpasscberecipentaccno_ET = findViewById(R.id.expiredpasscberecipentaccno_ET);
        expiredpasscbeamount_ET = findViewById(R.id.expiredpasscbeamount_ET);
        paymentinstruction = findViewById(R.id.paymentinstruction);
        expiredpasspay_btn = findViewById(R.id.expiredpasspay_btn);
        mFirebaseFirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        expiredpasspay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkForm();
            }
        });

    }

    private void checkForm() {
        String fullname = expiredpasscbefullname_ET.getText().toString();
        String recipentaccountno = expiredpasscberecipentaccno_ET.getText().toString();
        String amount = expiredpasscbeamount_ET.getText().toString();
        if (fullname.isEmpty()) {
            expiredpasscbefullname_ET.setError("Enetr Fullname!");
            expiredpasscbefullname_ET.requestFocus();
        } else if (recipentaccountno.isEmpty()) {
            expiredpasscberecipentaccno_ET.setError("Enetr Recipent Number!");
            expiredpasscberecipentaccno_ET.requestFocus();
        } else if (amount.isEmpty()) {
            expiredpasscbeamount_ET.setError("Enetr Amount!");
            expiredpasscbeamount_ET.requestFocus();
        } else {
            final DocumentReference documentReference = mFirebaseFirestore.collection("Bank System").document();
            documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if (documentSnapshot.exists()) {
                        String Balance = documentSnapshot.getString("Balance");
//                    String Email = documentSnapshot.getString("email");
//                    String Phone = documentSnapshot.getString("Phone");
                        //String Userid=documentSnapshot.getString("userID");
//                    profile_fullname_TV.setText(Fullname);
//                    profile_email_TV.setText(Email);
//                    profile_phone_TV.setText(Phone);
//                    profile_userid_TV.setText(userID);
                        paymentinstruction.setText(Balance);

                    } else {
                        Toast.makeText(getApplicationContext(), "Document doesnot exist", Toast.LENGTH_LONG).show();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), "Error!", Toast.LENGTH_SHORT).show();
                }

            });
        }
    }
}