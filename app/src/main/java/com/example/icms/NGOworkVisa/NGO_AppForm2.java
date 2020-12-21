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

public class NGO_AppForm2 extends AppCompatActivity {
    public Uri ngo_fileuri;
    Button NGO_appform2next_btn, ngo_download_btn;
    TextView ngo_filechooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_g_o__app_form2);
        NGO_appform2next_btn = findViewById(R.id.NGO_appform2next_btn);
        ngo_filechooser = findViewById(R.id.ngo_filechooser);
        ngo_download_btn = findViewById(R.id.ngo_download_btn);

        ngo_filechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosefile();
            }
        });
    }

    private void choosefile() {
        Intent intents = new Intent();
        intents.setType("*/*");
        intents.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intents, "Select PDF file"), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path = data.getData().getPath();
            ngo_filechooser.setText(path);
            ngo_fileuri = data.getData();
            //tv_arrival_photochooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        NGO_appform2next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadpdftofirestore(data.getData());
                Intent intent = new Intent(NGO_AppForm2.this, NGO_AppForm3.class);
                startActivity(intent);
            }
        });
    }

    private void Uploadpdftofirestore(Uri data) {
    }
}