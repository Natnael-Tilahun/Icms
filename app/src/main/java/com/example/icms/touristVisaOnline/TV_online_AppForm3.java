package com.example.icms.touristVisaOnline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class TV_online_AppForm3 extends AppCompatActivity {
    Button TV_online_appform3next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_v_online__app_form3);
        TV_online_appform3next_btn = findViewById(R.id.TV_online_appform3next_btn);
        TV_online_appform3next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TV_online_AppForm3.this, TV_onlineAppForm4.class);
                startActivity(intent);
            }
        });
    }
}