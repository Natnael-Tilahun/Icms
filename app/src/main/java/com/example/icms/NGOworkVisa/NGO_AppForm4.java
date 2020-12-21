package com.example.icms.NGOworkVisa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class NGO_AppForm4 extends AppCompatActivity {
    Button NGO_appform4next_btn;
    public Uri ngo_applicationletteruri, ngo_registrationlicenceuri;
    TextView ngo_applicationletterchooser, ngo_registrationlicencechooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_g_o__app_form4);
        NGO_appform4next_btn = findViewById(R.id.NGO_appform4next_btn);
        ngo_applicationletterchooser = findViewById(R.id.ngo_applicationletterchooser);
        ngo_registrationlicencechooser = findViewById(R.id.ngo_registrationlicencechooser);

        ngo_applicationletterchooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseappicationletterfile();
            }
        });

        ngo_registrationlicencechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosenoteverbalefile();
            }
        });
    }

    private void chooseappicationletterfile() {
        Intent intents = new Intent();
        intents.setType("*/*");
        intents.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intents, "Select PDF file"), 1);
    }

    private void choosenoteverbalefile() {
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
            ngo_applicationletterchooser.setText(path);
            ngo_applicationletteruri = data.getData();
            //tv_arrival_photochooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path1 = data.getData().getPath();
            ngo_registrationlicencechooser.setText(path1);
            //tvarrivalpassportcopychooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            ngo_registrationlicenceuri = data.getData();

        }
        NGO_appform4next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadpdftofirestore(data.getData());
                Intent intent = new Intent(NGO_AppForm4.this, NGO_AppForm5.class);
                startActivity(intent);
            }
        });
    }

    private void Uploadpdftofirestore(Uri data) {
    }
}