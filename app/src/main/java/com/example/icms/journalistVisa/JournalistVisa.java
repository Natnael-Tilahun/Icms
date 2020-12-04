package com.example.icms.journalistVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class JournalistVisa extends AppCompatActivity {
    Button JV_next_btn;
    EditText JV_citizenship_ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journalist_visa);
        JV_next_btn = findViewById(R.id.JV_next_btn);
        JV_citizenship_ET = findViewById(R.id.JV_citizenship_ET);

        JV_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkform();
            }
        });
    }

    private void checkform() {
        String JV_citizenship = JV_citizenship_ET.getText().toString().trim();
        if (JV_citizenship.isEmpty()) {
            JV_citizenship_ET.setError("Please insert your CitizenShip!");
            JV_citizenship_ET.requestFocus();
        } else {
            Intent intent = new Intent(JournalistVisa.this, JV_AppForm2.class);
            startActivity(intent);
        }
    }
}