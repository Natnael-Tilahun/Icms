package com.example.icms;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Notification extends AppCompatActivity {
    TextView notification_TV1, notification_TV2, notification_TV3, notification_TV4, notification_TV5, notification_TV6, notification_TV7, notification_TV8, notification_TV9, notification_TV10, notification_TV11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        notification_TV1 = findViewById(R.id.notification_TV1);
        notification_TV2 = findViewById(R.id.notification_TV2);
        notification_TV3 = findViewById(R.id.notification_TV3);
        notification_TV4 = findViewById(R.id.notification_TV4);
        notification_TV5 = findViewById(R.id.notification_TV5);
        notification_TV6 = findViewById(R.id.notification_TV6);
        notification_TV7 = findViewById(R.id.notification_TV7);
        notification_TV8 = findViewById(R.id.notification_TV8);
        notification_TV9 = findViewById(R.id.notification_TV9);
        notification_TV10 = findViewById(R.id.notification_TV10);
        notification_TV11 = findViewById(R.id.notification_TV11);
    }
}