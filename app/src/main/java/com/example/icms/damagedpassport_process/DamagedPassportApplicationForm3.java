package com.example.icms.damagedpassport_process;

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

public class DamagedPassportApplicationForm3 extends AppCompatActivity {
    public Uri damagedpassidfileuri, damagedpassbdcertificateuri;
    TextView damagedpassidfilechooser, damagedpassbirthcertificatefilechooser;
    Button damagedpassportappform4upload_btn;
    EditText damagedpassport_oldpassportno_ET;
    ProgressDialog mProgressDialog;
    FirebaseFirestore mFirestore;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_damaged_passport_application_form3);
        damagedpassidfilechooser = findViewById(R.id.newpassidfilechooser);
        damagedpassbirthcertificatefilechooser = findViewById(R.id.newpassportbirthcertificatefilechooser);
        damagedpassportappform4upload_btn = findViewById(R.id.damagedpassupload_btn);
        damagedpassport_oldpassportno_ET = findViewById(R.id.damagedpassport_oldpassportno_ET);
        mProgressDialog = new ProgressDialog(DamagedPassportApplicationForm3.this);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();

        damagedpassidfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseidfile();
            }
        });

        damagedpassbirthcertificatefilechooser.setOnClickListener(new View.OnClickListener() {
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
            damagedpassidfilechooser.setText(path);
            //damagedpassidfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            damagedpassidfileuri = data.getData();
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path1 = data.getData().getPath();
            damagedpassbirthcertificatefilechooser.setText(path1);
            //damagedpassbirthcertificatefilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            damagedpassbdcertificateuri = data.getData();
        }
        damagedpassportappform4upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Uploadpdftofirestore(data.getData());
                checkform();
            }
        });
    }

    private void checkform() {
        String damagedpassport_oldpassportno_ET1 = damagedpassport_oldpassportno_ET.getText().toString().trim();
        if (damagedpassport_oldpassportno_ET1.isEmpty()) {
            damagedpassport_oldpassportno_ET.setError("Please insert your old password Number!");
            damagedpassport_oldpassportno_ET.requestFocus();
        } else {
            addingDatasToFirestore();
        }
    }

    private void addingDatasToFirestore() {
        mProgressDialog.show();
        // mProgressBar.setVisibility(View.VISIBLE);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();
        String userID = (mFirebaseAuth.getCurrentUser()).getUid();
        String damagedpassidfileuri1 = damagedpassidfileuri.toString();
        String damagedpassbdcertificateuri1 = damagedpassbdcertificateuri.toString();
        String damagedpassport_oldpassportno_ET1 = damagedpassport_oldpassportno_ET.getText().toString().trim();

        final DocumentReference documentReference = mFirestore.collection("users").document(userID);

        Map<String, String> userdata = new HashMap<>();
        //userdata.put("UserID", userID);
        userdata.put("Legal ID", damagedpassidfileuri1);
        userdata.put("Birth Certificate", damagedpassbdcertificateuri1);
        userdata.put("Old Passport Number", damagedpassport_oldpassportno_ET1);
        mFirestore.collection("Service").document("PassportService").collection("Damaged Passport").document(userID).set(userdata, SetOptions.merge()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(DamagedPassportApplicationForm3.this, "Document Successfully submitted", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(DamagedPassportApplicationForm3.this, DamagedPassportApplicatonForm4.class);
                    startActivity(intent);
                    mProgressDialog.dismiss();

                } else {
                    Toast.makeText(DamagedPassportApplicationForm3.this, "Error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
//    private void Uploadpdftofirestore(Uri data) {
//    }
    }

}