package com.example.icms.expiredpassport_process;

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

public class ExpiredPassportApplicationForm2 extends AppCompatActivity {
    public Uri expiredpassfileUri;
    TextView expiredpassfilechooser;
    Button expiredpassportappform2next_btn, expiredpassdownload_btn;

    ProgressDialog mProgressDialog;
    FirebaseFirestore mFirestore;
    FirebaseAuth mFirebaseAuth;

    FirebaseStorage mFirebaseStorage;
    StorageReference mStorageReference;
    StorageReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expired_passport_application_form2);
        expiredpassfilechooser = findViewById(R.id.newpassfilechooser);
        expiredpassportappform2next_btn = findViewById(R.id.expiredpassportappform2next_btn);
        expiredpassdownload_btn = findViewById(R.id.expiredpassdownload_btn);
        mProgressDialog = new ProgressDialog(ExpiredPassportApplicationForm2.this);
        mFirestore = FirebaseFirestore.getInstance();

        expiredpassfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseFile();
            }

        });
        expiredpassdownload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                download();
            }
        });
    }

    private void download() {
        mStorageReference = FirebaseStorage.getInstance().getReference();
        ref = mStorageReference.child("/Application Forms/Passport Application Forms/New Passport Application Form/PassportApplicationForm.pdf");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                downloadFiles(getApplicationContext(), "ExpiredPassportApplicationForm", ".pdf", DIRECTORY_DOWNLOADS, url);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ExpiredPassportApplicationForm2.this, "Error:" + e.toString(), Toast.LENGTH_SHORT).show();

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
            expiredpassfilechooser.setText(path);
            //newpassfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")+1));
            //expiredpassfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")));
            expiredpassfileUri = data.getData();

            expiredpassportappform2next_btn.setOnClickListener(new View.OnClickListener() {
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
        String expiredpassidfileuri1 = expiredpassfileUri.toString();
        final DocumentReference documentReference = mFirestore.collection("users").document(userID);

        Map<String, String> userdata = new HashMap<>();
        //userdata.put("UserID", userID);
        userdata.put("Completed Form", expiredpassidfileuri1);
        mFirestore.collection("Service").document("PassportService").collection("Expired Passport").document(userID).set(userdata, SetOptions.merge()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(ExpiredPassportApplicationForm2.this, "Document Successfully submitted", Toast.LENGTH_LONG).show();
                    //mProgressBar.setVisibility(View.GONE);
                    Intent intent = new Intent(ExpiredPassportApplicationForm2.this, ExpiredPassportApplicationForm3.class);
                    startActivity(intent);
                    mProgressDialog.dismiss();

                } else {
                    Toast.makeText(ExpiredPassportApplicationForm2.this, "Error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
//    private void Uploadpdftofirestore(Uri data) {
//    }
    }
}

