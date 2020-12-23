package com.example.icms.urgentpassport_process;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class UrgentPassportApplicationForm3 extends AppCompatActivity {
    public Uri urgentpassidfileuri, urgentpassbdcertificateuri;
    TextView urgentpassidfilechooser, urgentpassbirthcertificatefilechooser;
    Button urgentpassportappform4upload_btn;
    ProgressDialog mProgressDialog;
    FirebaseFirestore mFirestore;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urgent_passport_application_form3);
        urgentpassidfilechooser = findViewById(R.id.newpassidfilechooser);
        urgentpassbirthcertificatefilechooser = findViewById(R.id.newpassportbirthcertificatefilechooser);
        urgentpassportappform4upload_btn = findViewById(R.id.urgentpassappform4upload_btn);
        mProgressDialog = new ProgressDialog(UrgentPassportApplicationForm3.this);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();

        urgentpassidfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseidfile();
            }
        });

        urgentpassbirthcertificatefilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosebdcertificatefile();
            }
        });
    }

    private void chooseidfile() {
        Intent intents = new Intent();
        intents.setType("*/*");
        intents.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intents, "Select PDF file"), 1);
    }

    private void choosebdcertificatefile() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select PDF file"), 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path = data.getData().getPath();
            urgentpassidfilechooser.setText(path);
            //urgentpassidfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")+1));
            urgentpassidfileuri = data.getData();
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path1 = data.getData().getPath();
            urgentpassbirthcertificatefilechooser.setText(path1);
            //urgentpassbirthcertificatefilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")+1));
            urgentpassbdcertificateuri = data.getData();
        }
        urgentpassportappform4upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Uploadpdftofirestore(data.getData());
                addingDatasToFirestore();
            }
        });
    }

    private void addingDatasToFirestore() {
        mProgressDialog.show();

        // mProgressBar.setVisibility(View.VISIBLE);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();
        String userID = (mFirebaseAuth.getCurrentUser()).getUid();
        String urgentpassidfileuri1 = urgentpassidfileuri.toString();
        String urgentpassbdcertificateuri1 = urgentpassbdcertificateuri.toString();
        final DocumentReference documentReference = mFirestore.collection("users").document(userID);

        Map<String, String> userdata = new HashMap<>();
        //userdata.put("UserID", userID);
        userdata.put("Legal ID", urgentpassidfileuri1);
        userdata.put("Birth Certificate", urgentpassbdcertificateuri1);

        mFirestore.collection("Service").document("PassportService").collection("Urgent Passport").document(userID).set(userdata, SetOptions.merge()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(UrgentPassportApplicationForm3.this, "Document Successfully submitted", Toast.LENGTH_LONG).show();
                    //mProgressBar.setVisibility(View.GONE);
                    Intent intent = new Intent(UrgentPassportApplicationForm3.this, UrgentPassportAppliacationForm4.class);
                    startActivity(intent);
                    mProgressDialog.dismiss();

                } else {
                    Toast.makeText(UrgentPassportApplicationForm3.this, "Error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
//    private void Uploadpdftofirestore(Uri data) {
//
//    }
}