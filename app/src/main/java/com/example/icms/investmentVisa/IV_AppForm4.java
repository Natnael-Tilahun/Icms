package com.example.icms.investmentVisa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class IV_AppForm4 extends AppCompatActivity {
    Button IV_appform4next_btn;
    public Uri iv_applicationletteruri, iv_bussinesslicenceuri, iv_supportletteruri;
    TextView iv_applicationletterchooser, iv_bussinesslicencechooser, iv_supportletterchooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i_v__app_form4);
        IV_appform4next_btn = findViewById(R.id.IV_appform4next_btn);
        iv_applicationletterchooser = findViewById(R.id.iv_applicationletterchooser);
        iv_bussinesslicencechooser = findViewById(R.id.iv_bussinesslicencechooser);
        iv_supportletterchooser = findViewById(R.id.iv_supportletterchooser);


        iv_applicationletterchooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseapplicationletter();
            }
        });

        iv_bussinesslicencechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosebussinesslicence();
            }
        });
        iv_supportletterchooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosesupportletter();
            }
        });
    }

    private void chooseapplicationletter() {
        Intent intents = new Intent();
        intents.setType("*/*");
        intents.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intents, "Select PDF file"), 1);
    }

    private void choosebussinesslicence() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select PDF file"), 2);
    }

    private void choosesupportletter() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select PDF file"), 3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for (int i = 1; i <= 3; i++) {
            if (requestCode == 1 && requestCode == i && resultCode == RESULT_OK && data != null && data.getData() != null) {
                String path = data.getData().getPath();
                iv_applicationletterchooser.setText(path);
                iv_applicationletteruri = data.getData();
                //tv_arrival_photochooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            }
            if (requestCode == 2 && requestCode == i && resultCode == RESULT_OK && data != null && data.getData() != null) {
                String path1 = data.getData().getPath();
                iv_bussinesslicencechooser.setText(path1);
                //tvarrivalpassportcopychooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
                iv_bussinesslicenceuri = data.getData();
            }

            if (requestCode == 3 && requestCode == i && resultCode == RESULT_OK && data != null && data.getData() != null) {
                String path1 = data.getData().getPath();
                iv_supportletterchooser.setText(path1);
                //tvarrivalpassportcopychooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
                iv_supportletteruri = data.getData();
            }
        }
        IV_appform4next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadpdftofirestore(data.getData());
                Intent intent = new Intent(IV_AppForm4.this, IV_AppForm5.class);
                startActivity(intent);
            }
        });
    }

    private void Uploadpdftofirestore(Uri data) {
    }
}