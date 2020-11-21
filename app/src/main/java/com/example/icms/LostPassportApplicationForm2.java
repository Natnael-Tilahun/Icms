package com.example.icms;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LostPassportApplicationForm2 extends AppCompatActivity {
    public Uri fileUri;
    TextView newpassfilechooser;
    Button lostpassappform2next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_passport_application_form2);
        newpassfilechooser = findViewById(R.id.newpassfilechooser);
        lostpassappform2next_btn = findViewById(R.id.lostpassportappform2next_btn);
        lostpassappform2next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LostPassportApplicationForm2.this, LostPassportApplicationForm3.class);
                startActivity(intent);
            }
        });
        newpassfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseFile();
            }
        });
    }

    private void chooseFile() {
        Intent intent = new Intent();
        intent.setType("pdf/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            fileUri = data.getData();
        }
    }
}
