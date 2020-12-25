package com.example.icms.touristVisaOnline;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class TV_onlineAppForm2 extends AppCompatActivity {
    Button TV_online_appform2next_btn;
    public Uri tvonlinedatafileUri;
    TextView tvonlinefilechooser;

    ProgressDialog mProgressDialog;
    FirebaseFirestore mFirestore;
    FirebaseAuth mFirebaseAuth;
    FirebaseStorage mFirebaseStorage;
    StorageReference mStorageReference;
    StorageReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_v_online_app_form2);
        TV_online_appform2next_btn = findViewById(R.id.TV_online_appform2next_btn);
        tvonlinefilechooser = findViewById(R.id.tvonlinefilechooser);
        mProgressDialog = new ProgressDialog(TV_onlineAppForm2.this);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();

        TV_online_appform2next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                download();
            }
        });
        tvonlinefilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseFile();
            }

        });
    }

    private void download() {
        mStorageReference = FirebaseStorage.getInstance().getReference();
        ref = mStorageReference.child("/Application Forms/Visa Application Form/TouristVisaOnlineApplicationForm.pdf");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                downloadFiles(getApplicationContext(), "TouristVisaOnlineApplicationForm", ".pdf", DIRECTORY_DOWNLOADS, url);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(TV_onlineAppForm2.this, "Error:" + e.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void downloadFiles(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);

        downloadManager.enqueue(request);
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
            tvonlinefilechooser.setText(path);
            //tvonlinefilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")+1));
            tvonlinedatafileUri = data.getData();


            TV_online_appform2next_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
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
        String tvonlinedatafileUri1 = tvonlinedatafileUri.toString();
        final DocumentReference documentReference = mFirestore.collection("users").document(userID);

        Map<String, String> userdata = new HashMap<>();
        //userdata.put("UserID", userID);
        userdata.put("Completed Form", tvonlinedatafileUri1);
        mFirestore.collection("Service").document("Visa Service").collection("Tourist Visa Online").document(userID).set(userdata, SetOptions.merge()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(TV_onlineAppForm2.this, "Document Successfully submitted", Toast.LENGTH_LONG).show();
                    //mProgressBar.setVisibility(View.GONE);
                    Intent intent = new Intent(TV_onlineAppForm2.this, TV_online_AppForm3.class);
                    startActivity(intent);
                    mProgressDialog.dismiss();

                } else {
                    Toast.makeText(TV_onlineAppForm2.this, "Error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}