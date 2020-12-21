package com.example.icms.expiredpassport_process;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class ExpiredPassportApplicationForm2 extends AppCompatActivity {
    public Uri expiredpassfileUri;
    TextView expiredpassfilechooser;
    Button expiredpassportappform2next_btn, expiredpassdownload_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expired_passport_application_form2);
        expiredpassfilechooser = findViewById(R.id.newpassfilechooser);
        expiredpassportappform2next_btn = findViewById(R.id.expiredpassportappform2next_btn);
        expiredpassdownload_btn = findViewById(R.id.expiredpassdownload_btn);

        expiredpassfilechooser.setOnClickListener(new View.OnClickListener() {
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
            expiredpassfilechooser.setText(path);
            //newpassfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")+1));
            //expiredpassfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")));
            expiredpassfileUri = data.getData();

            expiredpassportappform2next_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uploadpdftofirestore(data.getData());
                    Intent intent = new Intent(ExpiredPassportApplicationForm2.this, ExpiredPassportApplicationForm3.class);
                    startActivity(intent);
                }
            });

        }
    }

    private void Uploadpdftofirestore(Uri data) {

    }
}

