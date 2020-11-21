package com.example.icms.expiredpassport_process;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class ExpiredPassportApplicationForm3 extends AppCompatActivity {
    public Uri idfileuri;
    TextView newpassidfilechooser, newpassbirthcertificatefilechooser;
    Button expiredpassportappform4upload_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expired_passport_application_form3);
        newpassidfilechooser = findViewById(R.id.newpassidfilechooser);
        newpassbirthcertificatefilechooser = findViewById(R.id.newpassportbirthcertificatefilechooser);
        expiredpassportappform4upload_btn = findViewById(R.id.expiredpassupload_btn);
        expiredpassportappform4upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExpiredPassportApplicationForm3.this, ExpiredPassportApplicationForm4.class);
                startActivity(intent);
            }
        });

        newpassidfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosefile();
            }
        });
        newpassbirthcertificatefilechooser.setOnClickListener(new View.OnClickListener() {
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