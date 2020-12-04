package com.example.icms.touristVisaOnline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

import java.util.ArrayList;

public class TouristVisa_online extends AppCompatActivity {
    Spinner sp_TV_online;
    Button TV_online_next_btn;
    EditText TVonline_citizenship_ET;

    ArrayList<String> arrayList_TV_citizenship;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_visa_online);
        TV_online_next_btn = findViewById(R.id.TV_online_next_btn);
        TVonline_citizenship_ET = findViewById(R.id.TVonline_citizenship_ET);

        TV_online_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkform();
            }
        });
//        fillArraylist();
//        sp_TV_online.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                ArrayAdapter<String> arrayAdapter_tvonline=new ArrayAdapter<>(getApplicationContext(),R.layout.spinner_textview,arrayList_TV_citizenship);
//                sp_TV_online.setAdapter(arrayAdapter_tvonline);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//    }
//
//    private void fillArraylist() {
//        ArrayAdapter<String> arrayAdapter_tvonline;
//        arrayList_TV_citizenship=new ArrayList<>();
//        arrayList_TV_citizenship.add("Please Select Citizenship");
//        arrayList_TV_citizenship.add("Afghanistan");
//        arrayList_TV_citizenship.add("Albania");
//        arrayList_TV_citizenship.add("Algeria");
//        arrayList_TV_citizenship.add("American Samoa");
//        arrayList_TV_citizenship.add("Andorra");
//        arrayList_TV_citizenship.add("Angola");
//        arrayList_TV_citizenship.add("Anguilla");
//        arrayList_TV_citizenship.add("Antarctica");
//        arrayList_TV_citizenship.add("Antigua and Barbuda");
//        arrayList_TV_citizenship.add("Antilles Nether");
//        arrayList_TV_citizenship.add("Argentina");
//        arrayList_TV_citizenship.add("Armenia");
//        arrayList_TV_citizenship.add("Aruba");
//        arrayList_TV_citizenship.add("Australia");
//        arrayList_TV_citizenship.add("Austria");
//        arrayList_TV_citizenship.add("Azerbaijan");
//        arrayList_TV_citizenship.add("Bahamas");
//        arrayList_TV_citizenship.add("Bahrain");
//        arrayList_TV_citizenship.add("Bangladesh");
//        arrayList_TV_citizenship.add("Barbados");
//        arrayList_TV_citizenship.add("Belarus");
//        arrayList_TV_citizenship.add("Belgium");
//        arrayList_TV_citizenship.add("Belize");
//        arrayList_TV_citizenship.add("Benin");
//        arrayList_TV_citizenship.add("Bermuda");
//        arrayList_TV_citizenship.add("Bhutan");
//        arrayList_TV_citizenship.add("Bolivia");
//        arrayList_TV_citizenship.add("Bonaire St Eustatius and Saba ");
//        arrayList_TV_citizenship.add("Bosna and Herzegovina");
//        arrayList_TV_citizenship.add("Botswana");
//        arrayList_TV_citizenship.add("Bouvet Island");
//        arrayList_TV_citizenship.add("Brazil");
//        arrayList_TV_citizenship.add("British Indian ocean Territory");
//        arrayList_TV_citizenship.add("British Virgin Islands");
//        arrayList_TV_citizenship.add("Brunei Darussalam");
//        arrayList_TV_citizenship.add("Bulgaria");
//        arrayList_TV_citizenship.add("Burkina Faso");
//        arrayList_TV_citizenship.add("Burma");
//        arrayList_TV_citizenship.add("Burundi");
//        arrayList_TV_citizenship.add("Cambodia");
//        arrayList_TV_citizenship.add("Cameroon");
//        arrayList_TV_citizenship.add("Canada");
//        arrayList_TV_citizenship.add("Select Citizenship");
//        arrayList_TV_citizenship.add("Select Citizenship");
//        arrayList_TV_citizenship.add("Select Citizenship");
//        arrayList_TV_citizenship.add("Select Citizenship");
//
    }

    private void checkform() {
        String TVonline_citizenship = TVonline_citizenship_ET.getText().toString().trim();
        if (TVonline_citizenship.isEmpty()) {
            TVonline_citizenship_ET.setError("Please insert your CitizenShip!");
            TVonline_citizenship_ET.requestFocus();
        } else {
            Intent intent = new Intent(TouristVisa_online.this, TV_onlineAppForm2.class);
            startActivity(intent);
        }
    }
}
