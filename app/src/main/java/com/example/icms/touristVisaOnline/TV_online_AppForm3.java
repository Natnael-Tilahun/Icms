package com.example.icms.touristVisaOnline;

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

public class TV_online_AppForm3 extends AppCompatActivity {
    Button TV_online_appform3next_btn;
    public Uri tvonlinephotofileuri, tvonlinepassportcopyuri;
    TextView tvonlinepassportcopychooser, TV_online_photochooser;
    ProgressDialog mProgressDialog;
    FirebaseFirestore mFirestore;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_v_online__app_form3);
        TV_online_appform3next_btn = findViewById(R.id.TV_online_appform3next_btn);
        tvonlinepassportcopychooser = findViewById(R.id.tvonlinepassportcopychooser);
        TV_online_photochooser = findViewById(R.id.TV_online_photochooser);
        mProgressDialog = new ProgressDialog(TV_online_AppForm3.this);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();

        TV_online_photochooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosephoto();
            }
        });

        tvonlinepassportcopychooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosepassportcopy();
            }
        });
    }

    private void choosephoto() {
        Intent intents = new Intent();
        intents.setType("*/*");
        intents.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intents, "Select PDF file"), 1);
    }

    private void choosepassportcopy() {
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
            TV_online_photochooser.setText(path);
            //TV_online_photochooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            tvonlinephotofileuri = data.getData();
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path = data.getData().getPath();
            tvonlinepassportcopychooser.setText(path);
            //tvonlinepassportcopychooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            tvonlinepassportcopyuri = data.getData();
        }
        TV_online_appform3next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        String tvonlinephotofileuri1 = tvonlinephotofileuri.toString();
        String tvonlinepassportcopyuri1 = tvonlinepassportcopyuri.toString();

        final DocumentReference documentReference = mFirestore.collection("users").document(userID);

        Map<String, String> userdata = new HashMap<>();
        //userdata.put("UserID", userID);
        userdata.put("Legal ID", tvonlinephotofileuri1);
        userdata.put("Birth Certificate", tvonlinepassportcopyuri1);

        mFirestore.collection("Service").document("Visa Service").collection("Tourist Visa Online").document(userID).set(userdata, SetOptions.merge()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(TV_online_AppForm3.this, "Document Successfully submitted", Toast.LENGTH_LONG).show();
                    //mProgressBar.setVisibility(View.GONE);
                    Intent intent = new Intent(TV_online_AppForm3.this, TV_onlineAppForm4.class);
                    startActivity(intent);
                    mProgressDialog.dismiss();

                } else {
                    Toast.makeText(TV_online_AppForm3.this, "Error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}