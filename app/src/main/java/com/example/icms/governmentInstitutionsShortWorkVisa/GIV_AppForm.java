package com.example.icms.governmentInstitutionsShortWorkVisa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class GIV_AppForm extends AppCompatActivity {
    Button GIV_appformnext_btn;
    public Uri giv_photouri, giv_passportcopyuri;
    TextView giv_photochooser, giv_passportcopychooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_i_v__app_form);
        GIV_appformnext_btn = findViewById(R.id.GIV_appformnext_btn);
        giv_photochooser = findViewById(R.id.giv_photochooser);
        giv_passportcopychooser = findViewById(R.id.giv_passportcopychooser);

        giv_photochooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseappicationletterfile();
            }
        });

        giv_passportcopychooser.setOnClickListener(new View.OnClickListener() {
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
            giv_photochooser.setText(path);
            giv_photouri = data.getData();
            //tv_arrival_photochooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path1 = data.getData().getPath();
            giv_passportcopychooser.setText(path1);
            //tvarrivalpassportcopychooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            giv_passportcopyuri = data.getData();

        }
        GIV_appformnext_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadpdftofirestore(data.getData());
                Intent intent = new Intent(GIV_AppForm.this, GIV_AppForm3.class);
                startActivity(intent);
            }
        });
    }

    private void Uploadpdftofirestore(Uri data) {
    }
}