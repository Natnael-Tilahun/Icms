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

public class GIV_AppForm3 extends AppCompatActivity {
    Button GIV_appform3next_btn;
    public Uri giv_applicationletteruri;
    TextView giv_applicationletterchooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_i_v__app_form3);
        GIV_appform3next_btn = findViewById(R.id.GIV_appform3next_btn);
        giv_applicationletterchooser = findViewById(R.id.giv_applicationletterchooser);

        giv_applicationletterchooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseapplicationletterfile();
            }
        });
    }

    private void chooseapplicationletterfile() {
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
            giv_applicationletterchooser.setText(path);
            giv_applicationletteruri = data.getData();
            //tv_arrival_photochooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        GIV_appform3next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadpdftofirestore(data.getData());
                Intent intent = new Intent(GIV_AppForm3.this, GIV_AppForm4.class);
                startActivity(intent);
            }
        });
    }

    private void Uploadpdftofirestore(Uri data) {
    }
}