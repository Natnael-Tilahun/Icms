package com.example.icms.newpassport_process;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;
import com.google.firebase.storage.FirebaseStorage;

public class NewPassportApplicationForm2 extends AppCompatActivity {
    public Uri fileUri;
    TextView newpassfilechooser;
    Button newpassappform2next_btn, newpassdownload_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_passport_application_form2);
        newpassfilechooser = findViewById(R.id.newpassfilechooser);
        newpassappform2next_btn = findViewById(R.id.newpassappform2next_btn);
        newpassdownload_btn = findViewById(R.id.newpassdownload_btn);

        newpassfilechooser.setOnClickListener(new View.OnClickListener() {
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
            newpassfilechooser.setText(path);
            //newpassfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")+1));
            fileUri = data.getData();
            newpassappform2next_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uploadpdftofirestore(data.getData());
                    Intent intent = new Intent(NewPassportApplicationForm2.this, NewPassportApplicationForm3.class);
                    startActivity(intent);
                }
            });

        }
    }

    private void Uploadpdftofirestore(Uri data) {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        //StorageReference storageReference=storage.getReferenceFromUrl();
    }
}