package com.example.icms.lostpassport_process;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class LostPassportApplicationForm2 extends AppCompatActivity {
    public Uri lostpassfileUri;
    TextView lostpassfilechooser;
    Button lostpassappform2next_btn, lostpassdownload_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_passport_application_form2);
        lostpassfilechooser = findViewById(R.id.newpassfilechooser);
        lostpassappform2next_btn = findViewById(R.id.lostpassportappform2next_btn);
        lostpassdownload_btn = findViewById(R.id.lostpassdownload_btn);

        lostpassfilechooser.setOnClickListener(new View.OnClickListener() {
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
            //newpassfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")+1));
            String path = data.getData().getPath();
            lostpassfilechooser.setText(path);
            //lostpassfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")));
            lostpassfileUri = data.getData();
            lostpassappform2next_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uploadpdftofirestore(data.getData());
                    Intent intent = new Intent(LostPassportApplicationForm2.this, LostPassportApplicationForm3.class);
                    startActivity(intent);
                }
            });

        }
    }

    private void Uploadpdftofirestore(Uri data) {

    }
}
