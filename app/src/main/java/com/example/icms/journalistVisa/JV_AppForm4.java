package com.example.icms.journalistVisa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;
import com.example.icms.foreignBusinessFirmEmploymentVisa.FV_AppForm3;
import com.example.icms.foreignBusinessFirmEmploymentVisa.FV_AppForm4;

public class JV_AppForm4 extends AppCompatActivity {
    Button JV_appform4next_btn;
    public Uri jv_applicationletteruri, jv_supportletteruri;
    TextView jv_applicationletterchooser, jv_supportletterchooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_v__app_form4);
        JV_appform4next_btn = findViewById(R.id.JV_appform4next_btn);
        jv_applicationletterchooser = findViewById(R.id.jv_applicationletterchooser);
        jv_supportletterchooser = findViewById(R.id.jv_supportletterchooser);

        jv_applicationletterchooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseapplicationletterfile();
            }
        });

        jv_supportletterchooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosesupportletterfile();
            }
        });
    }

    private void chooseapplicationletterfile() {
        Intent intents = new Intent();
        intents.setType("*/*");
        intents.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intents, "Select PDF file"), 1);
    }

    private void choosesupportletterfile() {
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
            jv_applicationletterchooser.setText(path);
            jv_applicationletteruri = data.getData();
            //tv_arrival_photochooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path1 = data.getData().getPath();
            jv_supportletterchooser.setText(path1);
            //tvarrivalpassportcopychooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            jv_supportletteruri = data.getData();

        }
        JV_appform4next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadpdftofirestore(data.getData());

                Intent intent = new Intent(JV_AppForm4.this, JV_AppForm5.class);
                startActivity(intent);
            }
        });
    }

    private void Uploadpdftofirestore(Uri data) {
    }
}