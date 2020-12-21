package com.example.icms.damagedpassport_process;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class DamagedPassportApplicationForm2 extends AppCompatActivity {
    public Uri damagedpassfileUri;
    TextView damagedpassfilechooser;
    Button damagedpassappform2next_btn, damagedpassdownload_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_damaged_passport_application_form2);
        damagedpassfilechooser = findViewById(R.id.newpassfilechooser);
        damagedpassappform2next_btn = findViewById(R.id.damagedpassappform2next_btn);
        damagedpassdownload_btn = findViewById(R.id.damagedpassdownload_btn);

        damagedpassfilechooser.setOnClickListener(new View.OnClickListener() {
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
            damagedpassfilechooser.setText(path);
            //damagedpassfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")+1));
            damagedpassfileUri = data.getData();
            damagedpassappform2next_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uploadpdftofirestore(data.getData());
                    Intent intent = new Intent(DamagedPassportApplicationForm2.this, DamagedPassportApplicationForm3.class);
                    startActivity(intent);
                }
            });

        }
    }

    private void Uploadpdftofirestore(Uri data) {

    }
}