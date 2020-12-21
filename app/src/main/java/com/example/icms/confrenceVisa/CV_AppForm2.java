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

public class CV_AppForm2 extends AppCompatActivity {
    Button CV_appform2next_btn;
    public Uri cvisafileuri;
    TextView cvisafilechooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_v__app_form2);
        CV_appform2next_btn = findViewById(R.id.CV_appform2next_btn);
        cvisafilechooser = findViewById(R.id.cvisafilechooser);

        cvisafilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseFile();
            }

        });
    }

    private void chooseFile() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select PDF file"), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path = data.getData().getPath();
            cvisafilechooser.setText(path);
            //cvisafilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")+1));
            // tvonlinefilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")));
            cvisafileuri = data.getData();

            CV_appform2next_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uploadpdftofirestore(data.getData());
                    Intent intent = new Intent(CV_AppForm2.this, CV_AppForm3.class);
                    startActivity(intent);
                }
            });

        }
    }

    private void Uploadpdftofirestore(Uri data) {

    }
}