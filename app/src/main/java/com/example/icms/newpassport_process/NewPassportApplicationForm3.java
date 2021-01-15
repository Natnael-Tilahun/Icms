package com.example.icms.newpassport_process;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class NewPassportApplicationForm3 extends AppCompatActivity {
    public Uri idfileuri, bdcertificatefileuri;
    TextView newpassidfilechooser, newpassbirthcertificatefilechooser;
    Button newpassportappform4upload_btn;
    ProgressDialog mProgressDialog;
    FirebaseFirestore mFirestore;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_passport_application_form3);
        newpassbirthcertificatefilechooser = findViewById(R.id.newpassportbirthcertificatefilechooser);
        newpassidfilechooser = findViewById(R.id.newpassidfilechooser);
        newpassportappform4upload_btn = findViewById(R.id.newpassappform4upload_btn);
        mProgressDialog = new ProgressDialog(NewPassportApplicationForm3.this);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();

        //new passport id file chooser
        newpassidfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseidFile();
            }
        });

        //new passport birth certificate chooser textview
        newpassbirthcertificatefilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosebirthcertificateFile();
            }
        });
    }

    private void chooseidFile() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select PDF file"), 1);
    }

    private void choosebirthcertificateFile() {
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
            newpassidfilechooser.setText(path);
            idfileuri = data.getData();
            //newpassidfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            // newpassbirthcertificatefilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path1 = data.getData().getPath();
            newpassbirthcertificatefilechooser.setText(path1);
            bdcertificatefileuri = data.getData();
            //newpassidfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            //newpassbirthcertificatefilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        newpassportappform4upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NewPassportApplicationForm3.this, "Thank You!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NewPassportApplicationForm3.this, NewPassportApplicationForm4.class);
                startActivity(intent);
                //Uploadpdftofirestore(data.getData());
                //addingDatasToFirestore();
            }
        });
    }

//    private void addingDatasToFirestore() {
//        mProgressDialog.show();
//        mFirebaseAuth = FirebaseAuth.getInstance();
//        mFirestore = FirebaseFirestore.getInstance();
//        String userID = (mFirebaseAuth.getCurrentUser()).getUid();
//        String idfileuri1 = idfileuri.toString();
//        String bdcertificatefileuri1 = bdcertificatefileuri.toString();
//        final DocumentReference documentReference = mFirestore.collection("users").document(userID);
//
//        Map<String, String> userdata = new HashMap<>();
//        //userdata.put("UserID", userID);
//        userdata.put("Legal ID", idfileuri1);
//        userdata.put("Birth Certificate", bdcertificatefileuri1);
//
//        mFirestore.collection("Service").document("PassportService").collection("New Passport").document(userID).set(userdata, SetOptions.merge()).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isSuccessful()) {
//                    Toast.makeText(NewPassportApplicationForm3.this, "Document Successfully submitted", Toast.LENGTH_LONG).show();
//                    //mProgressBar.setVisibility(View.GONE);
//                    Intent intent = new Intent(NewPassportApplicationForm3.this, NewPassportApplicationForm4.class);
//                    startActivity(intent);
//                    mProgressDialog.dismiss();
//
//                } else {
//                    Toast.makeText(NewPassportApplicationForm3.this, "Error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }

//    private void Uploadpdftofirestore(Uri data) {
//    }
}