package com.example.icms;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Notification extends AppCompatActivity {
    TextView notification_TV1, notification_TV2, notification_TV3, notification_TV4, notification_TV5, notification_TV6, notification_TV7, notification_TV8, notification_TV9, notification_TV10, notification_TV11;
    FirebaseFirestore mFirebaseFirestore;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        notification_TV1 = findViewById(R.id.notification_TV1);
        notification_TV2 = findViewById(R.id.notification_TV2);
        notification_TV3 = findViewById(R.id.notification_TV3);
        notification_TV4 = findViewById(R.id.notification_TV4);
        notification_TV5 = findViewById(R.id.notification_TV5);
        notification_TV6 = findViewById(R.id.notification_TV6);
        notification_TV7 = findViewById(R.id.notification_TV7);
        notification_TV8 = findViewById(R.id.notification_TV8);
        notification_TV9 = findViewById(R.id.notification_TV9);
        notification_TV10 = findViewById(R.id.notification_TV10);
        notification_TV11 = findViewById(R.id.notification_TV11);
        mFirebaseFirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        sendingMessage();
    }

    private void sendingMessage() {
        String id = mFirebaseFirestore.collection("Bank System").document().getId();
        String userID = mAuth.getCurrentUser().getUid();
        final DocumentReference documentReference = mFirebaseFirestore.collection("Notifications").document(userID);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    String Message = documentSnapshot.getString("Message");
                    String Message1 = documentSnapshot.getString("Message1");
                    String Message2 = documentSnapshot.getString("Message2");

                    //                    String Email = documentSnapshot.getString("email");
//                    String Phone = documentSnapshot.getString("Phone");
                    //String Userid=documentSnapshot.getString("userID");
                    notification_TV1.setText(Message);
                    notification_TV2.setText(Message1);
                    notification_TV3.setText(Message2);
//                    profile_email_TV.setText(Email);
//                    profile_phone_TV.setText(Phone);
//                    profile_userid_TV.setText(userID);

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