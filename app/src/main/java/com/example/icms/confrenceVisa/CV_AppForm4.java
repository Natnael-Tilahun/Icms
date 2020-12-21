package com.example.icms.confrenceVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class CV_AppForm4 extends AppCompatActivity {
    Button CV_appform4next_btn;
    TextView confrencename_ET, confrencestartdate_ET, confrenceenddate_ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_v__app_form4);
        CV_appform4next_btn = findViewById(R.id.CV_appform4next_btn);
        confrencename_ET = findViewById(R.id.confrencename_ET);
        confrencestartdate_ET = findViewById(R.id.confrencestartdate_ET);
        confrenceenddate_ET = findViewById(R.id.confrenceenddate_ET);

        CV_appform4next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkform();
            }
        });
    }

    private void checkform() {
        String confrencename = confrencename_ET.getText().toString().trim();
        String confrencestartdate = confrencestartdate_ET.getText().toString().trim();
        String confrenceenddate = confrenceenddate_ET.getText().toString().trim();

        if (confrencename.isEmpty()) {
            confrencename_ET.setError("Please insert your conference name!");
            confrencename_ET.requestFocus();
        } else if (confrencestartdate.isEmpty()) {
            confrencestartdate_ET.setError("Please insert your conference start date!");
            confrencestartdate_ET.requestFocus();
        } else if (confrenceenddate.isEmpty()) {
            confrenceenddate_ET.setError("Please insert your conference end date!");
            confrenceenddate_ET.requestFocus();
        } else {
            Intent intent = new Intent(CV_AppForm4.this, CV_AppForm5.class);
            startActivity(intent);
        }
    }
}