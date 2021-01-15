package com.example.icms.newpassport_process;

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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.icms.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class NewPassportApplicationForm2 extends AppCompatActivity {
    public Uri fileUri;
    TextView newpassfilechooser;
    Button newpassappform2next_btn, newpassdownload_btn;
    ProgressDialog mProgressDialog;
    FirebaseFirestore mFirestore;
    FirebaseAuth mFirebaseAuth;
    FirebaseStorage mFirebaseStorage;
    StorageReference mStorageReference;
    StorageReference ref;
    File file;
    String site, city, office, delivery, appointment_date, date;
    String appintment_time;
    String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_passport_application_form2);
        newpassfilechooser = findViewById(R.id.newpassfilechooser);
        newpassappform2next_btn = findViewById(R.id.newpassappform2next_btn);
        newpassdownload_btn = findViewById(R.id.newpassdownload_btn);
        mProgressDialog = new ProgressDialog(NewPassportApplicationForm2.this);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();

        newpassfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new MultipartUploadRequest
                chooseFile();
            }

        });
        newpassdownload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                download();
            }
        });

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            site = extras.getString("site");
            city = extras.getString("city");
            office = extras.getString("office");
            delivery = extras.getString("delivery");
            appointment_date = extras.getString("appointment_date");
            appintment_time = extras.getString("appintment_time");
        }
    }

    private void download() {
        mStorageReference = FirebaseStorage.getInstance().getReference();
        ref = mStorageReference.child("/Application Forms/Passport Application Forms/New Passport Application Form/PassportApplicationForm.pdf");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String url = uri.toString();
                downloadFiles(getApplicationContext(), "NewPassportApplicationForm", ".pdf", DIRECTORY_DOWNLOADS, url);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(NewPassportApplicationForm2.this, "Error:" + e.toString(), Toast.LENGTH_SHORT).show();

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
            Uri filepath = data.getData();
            filename = filepath.getLastPathSegment();
            newpassfilechooser.setText(filename);
            fileUri = data.getData();
            file = new File(path.toString());
            try {
                getStringFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            newpassappform2next_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Uploadpdftofirestore(data.getData());
                    //addingDatasToFirestore();
                    uploadingFile();
                    Intent intent = new Intent(NewPassportApplicationForm2.this, NewPassportApplicationForm3.class);
//                    intent.putExtra("site", site);
//                    intent.putExtra("city", city);
//                    intent.putExtra("office", office);
//                    intent.putExtra("delivery", delivery);
//                    intent.putExtra("Appintment_date",appointment_date);
//                    intent.putExtra("Appintment_time", appointment_time);
                    startActivity(intent);
                }
            });

        }
    }

    private String getStringFile(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append("\n");
                bufferedReader.close();
            }
        } catch (FileNotFoundException e) {
            //String line = null;
            e.printStackTrace();
        }
        return sb.toString();
    }

    private void uploadingFile() {
        StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.43.60/project/insert.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.equalsIgnoreCase("Data Inserted")) {
                            Toast.makeText(NewPassportApplicationForm2.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                            mProgressDialog.dismiss();
                        } else {
                            Toast.makeText(NewPassportApplicationForm2.this, response, Toast.LENGTH_SHORT).show();
                            mProgressDialog.dismiss();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(NewPassportApplicationForm2.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                mProgressDialog.dismiss();
            }
        }

        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // String completed_form= null;
//                    try {
//                      //  completed_form = getStringFile(file);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }

                Map<String, String> params = new HashMap<String, String>();

                params.put("site", site);
                params.put("city", city);
                params.put("office", office);
                params.put("delivery", delivery);
                params.put("appointment_date", appointment_date);
                params.put("appintment_time", appintment_time);
                // params.put("completed_form",completed_form);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(NewPassportApplicationForm2.this);
        requestQueue.add(request);

    }

//    private void addingDatasToFirestore() {
//        mProgressDialog.show();
//        // mProgressBar.setVisibility(View.VISIBLE);
//        mFirebaseAuth = FirebaseAuth.getInstance();
//        mFirestore = FirebaseFirestore.getInstance();
//        String userID = (mFirebaseAuth.getCurrentUser()).getUid();
//        String fileUri1 = fileUri.toString();
//        final DocumentReference documentReference = mFirestore.collection("users").document(userID);
//
//        Map<String, String> userdata = new HashMap<>();
//        //userdata.put("UserID", userID);
//        userdata.put("Completed Form", fileUri1);
//        mFirestore.collection("Service").document("PassportService").collection("New Passport").document(userID).set(userdata, SetOptions.merge()).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isSuccessful()) {
//                    Toast.makeText(NewPassportApplicationForm2.this, "Document Successfully submitted", Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(NewPassportApplicationForm2.this, NewPassportApplicationForm3.class);
//                    startActivity(intent);
//                    mProgressDialog.dismiss();
//
//                } else {
//                    Toast.makeText(NewPassportApplicationForm2.this, "Error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
////    private void Uploadpdftofirestore(Uri data) {
////    }
//    }

}