package com.example.icms.touristVisaOnarrival;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class TV_onarrival_AppForm2 extends AppCompatActivity {
    Button TV_onarrivalappform2next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_v_onarrival__app_form2);
        TV_onarrivalappform2next_btn = findViewById(R.id.TV_onarrivalappform2next_btn);
        TV_onarrivalappform2next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TV_onarrival_AppForm2.this, TV_onarrival_AppForm3.class);
                startActivity(intent);
            }
        });
    }
}