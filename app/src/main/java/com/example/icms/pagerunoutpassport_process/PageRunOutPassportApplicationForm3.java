package com.example.icms.pagerunoutpassport_process;

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

public class PageRunOutPassportApplicationForm3 extends AppCompatActivity {
    public Uri pagerunoutpassidfileuri, pagerunoutbdcertificateuri;
    TextView pagerunoutpassidfilechooser, pagerunoutpassbirthcertificatefilechooser;
    Button pagerunoutpassportappform4upload_btn;
    EditText pagerunoutpassport_oldpassportno_ET;
    ProgressDialog mProgressDialog;
    FirebaseFirestore mFirestore;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_run_out_passport_application_form3);
        pagerunoutpassidfilechooser = findViewById(R.id.newpassidfilechooser);
        pagerunoutpassbirthcertificatefilechooser = findViewById(R.id.newpassportbirthcertificatefilechooser);
        pagerunoutpassportappform4upload_btn = findViewById(R.id.pagerunoutappform4upload_btn);
        pagerunoutpassport_oldpassportno_ET = findViewById(R.id.pagerunoutpassport_oldpassportno_ET);
        mProgressDialog = new ProgressDialog(PageRunOutPassportApplicationForm3.this);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();

        pagerunoutpassidfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseidfile();
            }
        });

        pagerunoutpassbirthcertificatefilechooser.setOnClickListener(new View.OnClickListener() {
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
            pagerunoutpassidfilechooser.setText(path);
            //pagerunoutpassidfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            pagerunoutpassidfileuri = data.getData();
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path1 = data.getData().getPath();
            pagerunoutpassbirthcertificatefilechooser.setText(path1);
            //pagerunoutpassbirthcertificatefilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            pagerunoutbdcertificateuri = data.getData();
        }
        pagerunoutpassportappform4upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Uploadpdftofirestore(data.getData());
                checkform();
                addingDatasToFirestore();
            }
        });
    }

    private void checkform() {
        String pagerunoutpassport_oldpassportno_ET1 = pagerunoutpassport_oldpassportno_ET.getText().toString().trim();
        if (pagerunoutpassport_oldpassportno_ET1.isEmpty()) {
            pagerunoutpassport_oldpassportno_ET.setError("Please insert your old password Number!");
            pagerunoutpassport_oldpassportno_ET.requestFocus();
        } else {
            addingDatasToFirestore();
        }
    }

    private void addingDatasToFirestore() {
        mProgressDialog.show();
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();
        String userID = (mFirebaseAuth.getCurrentUser()).getUid();
        String pagerunoutpassidfileuri1 = pagerunoutpassidfileuri.toString();
        String pagerunoutbdcertificateuri1 = pagerunoutbdcertificateuri.toString();
        String pagerunoutpassport_oldpassportno_ET1 = pagerunoutpassport_oldpassportno_ET.getText().toString().trim();

        final DocumentReference documentReference = mFirestore.collection("users").document(userID);

        Map<String, String> userdata = new HashMap<>();
        //userdata.put("UserID", userID);
        userdata.put("Legal ID", pagerunoutpassidfileuri1);
        userdata.put("Birth Certificate", pagerunoutbdcertificateuri1);
        userdata.put("Old Passport Number", pagerunoutpassport_oldpassportno_ET1);

        mFirestore.collection("Service").document("PassportService").collection("Passport Page Run Out").document(userID).set(userdata, SetOptions.merge()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(PageRunOutPassportApplicationForm3.this, "Document Successfully submitted", Toast.LENGTH_LONG).show();
                    //mProgressBar.setVisibility(View.GONE);
                    Intent intent = new Intent(PageRunOutPassportApplicationForm3.this, PageRunOutPassportApplicationForm4.class);
                    startActivity(intent);
                    mProgressDialog.dismiss();

                } else {
                    Toast.makeText(PageRunOutPassportApplicationForm3.this, "Error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

//    private void Uploadpdftofirestore(Uri data) {
//    }
}