package com.example.icms.damagedpassport_process;

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

public class DamagedPassportApplicationForm2 extends AppCompatActivity {
    public Uri damagedpassfileUri;
    TextView damagedpassfilechooser;
    Button damagedpassappform2next_btn, damagedpassdownload_btn;
    ProgressDialog mProgressDialog;
    FirebaseFirestore mFirestore;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_damaged_passport_application_form2);
        damagedpassfilechooser = findViewById(R.id.newpassfilechooser);
        damagedpassappform2next_btn = findViewById(R.id.damagedpassappform2next_btn);
        damagedpassdownload_btn = findViewById(R.id.damagedpassdownload_btn);
        mProgressDialog = new ProgressDialog(DamagedPassportApplicationForm2.this);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();

        damagedpassfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseFile();
            }
        });
    }

    private void chooseFile() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select PDF file"), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path = data.getData().getPath();
            damagedpassfilechooser.setText(path);
            //damagedpassfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")+1));
            damagedpassfileUri = data.getData();
            damagedpassappform2next_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Uploadpdftofirestore(data.getData());
                    addingDatasToFirestore();
                }
            });

        }
    }

    private void addingDatasToFirestore() {
        mProgressDialog.show();
        // mProgressBar.setVisibility(View.VISIBLE);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();
        String userID = (mFirebaseAuth.getCurrentUser()).getUid();
        String damagedpassfileUri1 = damagedpassfileUri.toString();
        final DocumentReference documentReference = mFirestore.collection("users").document(userID);

        Map<String, String> userdata = new HashMap<>();
        //userdata.put("UserID", userID);
        userdata.put("Completed Form", damagedpassfileUri1);
        mFirestore.collection("Service").document("PassportService").collection("Damaged Passport").document(userID).set(userdata, SetOptions.merge()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(DamagedPassportApplicationForm2.this, "Document Successfully submitted", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(DamagedPassportApplicationForm2.this, DamagedPassportApplicationForm3.class);
                    startActivity(intent);
                    mProgressDialog.dismiss();

                } else {
                    Toast.makeText(DamagedPassportApplicationForm2.this, "Error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
//    private void Uploadpdftofirestore(Uri data) {
//    }
    }

}