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

public class CV_AppForm5 extends AppCompatActivity implements View.OnClickListener {
    Button CV_appform5next_btn;
    public Uri cvinvitationletteruri, cvapplicationletteruri, cvtincertificateuri, cvbussinesslicenceruri;
    TextView cvisa_invitationletterchooser, cvisa_applicationletterchooser, cvisa_tincertificate_chooser, cvisa_businesslicense_chooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_v__app_form5);
        CV_appform5next_btn = findViewById(R.id.CV_appform5next_btn);
        cvisa_invitationletterchooser = findViewById(R.id.cvisa_invitationletterchooser);
        cvisa_applicationletterchooser = findViewById(R.id.cvisa_applicationletterchooser);
        cvisa_tincertificate_chooser = findViewById(R.id.cv_tincertificate_chooser);
        cvisa_businesslicense_chooser = findViewById(R.id.cv_businesslicense_chooser);

        cvisa_invitationletterchooser.setOnClickListener(this);
        cvisa_applicationletterchooser.setOnClickListener(this);
        cvisa_tincertificate_chooser.setOnClickListener(this);
        cvisa_businesslicense_chooser.setOnClickListener(this);
    }

    private void chooseinvitationletter() {
        Intent intents = new Intent();
        intents.setType("*/*");
        intents.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intents, "Select PDF file"), 1);
    }

    private void chooseapplicationletter() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select PDF file"), 2);
    }

    private void choosetincertificate() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select PDF file"), 3);
    }

    private void choosebussinesslience() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select PDF file"), 4);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path = data.getData().getPath();
            cvisa_invitationletterchooser.setText(path);
            cvinvitationletteruri = data.getData();
            // cvisa_invitationletterchooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path1 = data.getData().getPath();
            cvisa_applicationletterchooser.setText(path1);
            cvapplicationletteruri = data.getData();
            //cvisa_applicationletterchooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        if (requestCode == 3 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path2 = data.getData().getPath();
            cvisa_tincertificate_chooser.setText(path2);
            cvtincertificateuri = data.getData();
            //cvisa_tincertificate_chooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        if (requestCode == 4 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path3 = data.getData().getPath();
            cvisa_businesslicense_chooser.setText(path3);
            cvbussinesslicenceruri = data.getData();
            //cvisa_businesslicense_chooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        CV_appform5next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadpdftofirestore(data.getData());
                Intent intent = new Intent(CV_AppForm5.this, CV_AppForm6.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cvisa_invitationletterchooser:
                chooseinvitationletter();
                break;
            case R.id.cvisa_applicationletterchooser:
                chooseapplicationletter();
                break;
            case R.id.cv_tincertificate_chooser:
                choosetincertificate();
                break;
            case R.id.cv_businesslicense_chooser:
                choosebussinesslience();
                break;
        }
    }

    private void Uploadpdftofirestore(Uri data) {
    }
}