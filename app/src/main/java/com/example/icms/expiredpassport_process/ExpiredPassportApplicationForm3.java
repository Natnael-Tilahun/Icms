package com.example.icms.expiredpassport_process;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class ExpiredPassportApplicationForm3 extends AppCompatActivity {
    public Uri expiredpassidfileuri, expiredpassbdcertificatefileuri;
    TextView expiredpassidfilechooser, expiredpassbirthcertificatefilechooser;
    Button expiredpassportappform4upload_btn;
    EditText expiredpassport_oldpassportno_ET;
    ProgressDialog mProgressDialog;
    FirebaseFirestore mFirestore;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expired_passport_application_form3);
        expiredpassidfilechooser = findViewById(R.id.newpassidfilechooser);
        expiredpassbirthcertificatefilechooser = findViewById(R.id.newpassportbirthcertificatefilechooser);
        expiredpassportappform4upload_btn = findViewById(R.id.expiredpassupload_btn);
        expiredpassport_oldpassportno_ET = findViewById(R.id.expiredpassport_oldpassportno_ET);
        mProgressDialog = new ProgressDialog(ExpiredPassportApplicationForm3.this);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();

        expiredpassidfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseidFile();
            }
        });

        //new passport birth certificate chooser textview
        expiredpassbirthcertificatefilechooser.setOnClickListener(new View.OnClickListener() {
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
            expiredpassidfilechooser.setText(path);
            expiredpassidfileuri = data.getData();
            //expiredpassidfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path1 = data.getData().getPath();
            expiredpassbirthcertificatefilechooser.setText(path1);
            expiredpassbdcertificatefileuri = data.getData();
            //expiredpassbirthcertificatefilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        expiredpassportappform4upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Uploadpdftofirestore(data.getData());
                checkform();

            }
        });
    }

    private void checkform() {
        String expiredpassport_oldpassportno_ET1 = expiredpassport_oldpassportno_ET.getText().toString().trim();
        if (expiredpassport_oldpassportno_ET1.isEmpty()) {
            expiredpassport_oldpassportno_ET.setError("Please insert your old password Number!");
            expiredpassport_oldpassportno_ET.requestFocus();
        } else {
            addingDatasToFirestore();
        }
    }

    //    private void Uploadpdftofirestore(Uri data) {
//    }
    private void addingDatasToFirestore() {
        String oldpassportno = expiredpassport_oldpassportno_ET.getText().toString();
        mProgressDialog.show();

        // mProgressBar.setVisibility(View.VISIBLE);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();
        String userID = (mFirebaseAuth.getCurrentUser()).getUid();
        String expiredpassidfileuri1 = expiredpassidfileuri.toString();
        final DocumentReference documentReference = mFirestore.collection("users").document(userID);

        Map<String, String> userdata = new HashMap<>();
        //userdata.put("UserID", userID);
        userdata.put("Legal ID", expiredpassidfileuri1);
        userdata.put("Birth Certificate", expiredpassidfileuri1);
        userdata.put("Old Passport Number", oldpassportno);

        mFirestore.collection("Service").document("PassportService").collection("Expired Passport").document(userID).set(userdata, SetOptions.merge()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(ExpiredPassportApplicationForm3.this, "Document Successfully submitted", Toast.LENGTH_LONG).show();
                    //mProgressBar.setVisibility(View.GONE);
                    Intent intent = new Intent(ExpiredPassportApplicationForm3.this, ExpiredPassportApplicationForm4.class);
                    startActivity(intent);
                    mProgressDialog.dismiss();

                } else {
                    Toast.makeText(ExpiredPassportApplicationForm3.this, "Error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}