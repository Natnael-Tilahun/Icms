package com.example.icms.urgentpassport_process;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class UrgentPassportApplicationForm2 extends AppCompatActivity {
    public Uri urgentpassfileUri;
    TextView urgentpassfilechooser;
    Button urgentpassappform2next_btn, urgentpassdownload_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urgent_passport_application_form2);
        urgentpassfilechooser = findViewById(R.id.newpassfilechooser);
        urgentpassappform2next_btn = findViewById(R.id.urgentpassappform2next_btn);
        urgentpassdownload_btn = findViewById(R.id.urgentpassdownload_btn);

        urgentpassfilechooser.setOnClickListener(new View.OnClickListener() {
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
            String path1 = data.getData().getPath();
            urgentpassfilechooser.setText(path1);
            //newpassfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")+1));
            //urgentpassfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")));
            urgentpassfileUri = data.getData();
            urgentpassappform2next_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uploadpdftofirestore(data.getData());
                    Intent intent = new Intent(UrgentPassportApplicationForm2.this, UrgentPassportApplicationForm3.class);
                    startActivity(intent);
                }
            });

        }
    }

    private void Uploadpdftofirestore(Uri data) {

    }
}

