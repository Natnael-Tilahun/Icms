package com.example.icms;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NewPassportApplicationForm3 extends AppCompatActivity {
    public Uri idfileuri;
    TextView newpassidfilechooser, newpassbirthcertificatefilechooser;
    Button newpassportappform4upload_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_passport_application_form3);
        newpassbirthcertificatefilechooser = findViewById(R.id.newpassportbirthcertificatefilechooser);
        newpassidfilechooser = findViewById(R.id.newpassidfilechooser);
        newpassportappform4upload_btn = findViewById(R.id.newpassappform4upload_btn);
        newpassportappform4upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewPassportApplicationForm3.this, NewPassportApplicationForm4.class);
                startActivity(intent);
            }
        });

        //new passport id file chooser
        newpassidfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseFile();
            }
        });

        //new passport birth certificate chooser textview
        newpassbirthcertificatefilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseFile();
            }
        });
    }

    private void chooseFile() {
        Intent intent = new Intent();
        intent.setType("pdf/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            idfileuri = data.getData();
        }
    }
}