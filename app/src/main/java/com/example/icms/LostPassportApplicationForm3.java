package com.example.icms;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LostPassportApplicationForm3 extends AppCompatActivity {
    public Uri idfileuri;
    TextView lostpassidfilechooser, lostpassbirthcertificatefilechooser;
    Button lostpassportappform4upload_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_passport_application_form3);

        lostpassidfilechooser = findViewById(R.id.newpassidfilechooser);
        lostpassbirthcertificatefilechooser = findViewById(R.id.newpassportbirthcertificatefilechooser);
        lostpassportappform4upload_btn = findViewById(R.id.lostpassupload_btn);
        lostpassportappform4upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LostPassportApplicationForm3.this, LostPassportApplicationForm4.class);
                startActivity(intent);
            }
        });

        lostpassidfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosefile();
            }
        });

        lostpassbirthcertificatefilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosefile();
            }
        });
    }

    private void choosefile() {
        Intent intent = new Intent();
        intent.setType("pdf/*");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}