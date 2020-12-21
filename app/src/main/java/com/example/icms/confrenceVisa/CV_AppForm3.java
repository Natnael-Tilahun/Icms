package com.example.icms.confrenceVisa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class CV_AppForm3 extends AppCompatActivity {
    Button CV_appform3next_btn;
    public Uri cvisaphotofileuri, cvisapassportcopyuri;
    TextView cvisa_photochooser, cvisapassportcopychooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_v__app_form3);
        CV_appform3next_btn = findViewById(R.id.CV_appform3next_btn);
        cvisa_photochooser = findViewById(R.id.cvisa_photochooser);
        cvisapassportcopychooser = findViewById(R.id.cvisapassportcopychooser);

        cvisa_photochooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseidfile();
            }
        });

        cvisapassportcopychooser.setOnClickListener(new View.OnClickListener() {
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
            cvisa_photochooser.setText(path);
            //cvisa_photochooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            cvisaphotofileuri = data.getData();

        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path2 = data.getData().getPath();
            cvisapassportcopychooser.setText(path2);
            //cvisapassportcopychooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            cvisapassportcopyuri = data.getData();
        }
        CV_appform3next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadpdftofirestore(data.getData());
                Intent intent = new Intent(CV_AppForm3.this, CV_AppForm4.class);
                startActivity(intent);
            }
        });
    }

    private void Uploadpdftofirestore(Uri data) {
    }
}