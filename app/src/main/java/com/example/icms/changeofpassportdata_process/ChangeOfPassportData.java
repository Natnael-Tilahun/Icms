package com.example.icms.changeofpassportdata_process;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChangeOfPassportData extends AppCompatActivity {
    Spinner sp_site, sp_city, sp_office, sp_deliverysite;
    Button changeofpassdatanext_btn;
    TextView sp_site_error_TV;
    ArrayList<String> arrayList_site, arrayList_city, arrayList_office, arrayList_deliverysite;
    ProgressDialog mProgressDialog;
    FirebaseAuth mFirebaseAuth;
    FirebaseFirestore mFirestore;

    ArrayList<String> arrayList_AAdeliverysite, arrayList_bahirdardeliverysite, arrayList_dessiedeliverysite,
            arrayList_samaradeliverysite, arrayList_benishangulgumuzdeliverysite, arrayList_diredawadeliverysite,
            arrayList_adamadeliverysite, arrayList_jimmadeliverysite, arrayList_hawassadeliverysite,
            arrayList_mekelledeliverysite, arrayList_jigjigadeliverysite;

    ArrayList<String> arrayList_AAcity, arrayList_amharacity, arrayList_diredawacity, arrayList_afarcity,
            arrayList_benishangulgumuzcity, arrayList_oromiacity, arrayList_sidamacity, arrayList_tigraycity,
            arrayList_somalicity, arrayList_snnprcity;

    ArrayList<String> arrayList_AAoffice, arrayList_bahirdaroffice, arrayList_dessieoffice, arrayList_samaraoffice,
            arrayList_benishangulgumuzoffice, arrayList_diredawaoffice, arrayList_adamaoffice, arrayList_jimmaoffice,
            arrayList_hawassaoffice, arrayList_mekelleoffice, arrayList_jigjigaoffice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_of_passport_data);

        sp_site = findViewById(R.id.sp_site);
        sp_city = findViewById(R.id.sp_city);
        sp_office = findViewById(R.id.sp_office);
        sp_site_error_TV = findViewById(R.id.sp_invitingcompany_error_TV);
        sp_deliverysite = findViewById(R.id.sp_deliverysite);
        changeofpassdatanext_btn = findViewById(R.id.changeofpassdatanext_btn);
        mProgressDialog = new ProgressDialog(ChangeOfPassportData.this);
        fillArrayList();

        sp_site.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                itemSelectionListener();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        changeofpassdatanext_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkform();
            }
        });
    }

    private void checkform() {
        if (!(sp_site.getSelectedItemPosition() >= 1)) {
            sp_site_error_TV.setVisibility(View.VISIBLE);
            sp_site_error_TV.setError("please Select a site!");
            sp_site_error_TV.requestFocus();
        } else {
            sp_site_error_TV.setVisibility(View.GONE);
            addingDatasToFirestore();
        }

    }

    private void addingDatasToFirestore() {
        String site = sp_site.getSelectedItem().toString();
        String city = sp_city.getSelectedItem().toString();
        String office = sp_office.getSelectedItem().toString();
        String deliverysite = sp_deliverysite.getSelectedItem().toString();
        mProgressDialog.show();

        // mProgressBar.setVisibility(View.VISIBLE);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();
        String userID = (mFirebaseAuth.getCurrentUser()).getUid();
        final DocumentReference documentReference = mFirestore.collection("users").document(userID);
        Map<String, String> userdata = new HashMap<>();
        userdata.put("UserID", userID);
        userdata.put("Select Site", site);
        userdata.put("Select City", city);
        userdata.put("Select Office", office);
        userdata.put("Delivery Site", deliverysite);
//        userdata.put("Appointment Date", "+deliverysite");
//        userdata.put("Completed Form", "form.pdf");
//        userdata.put("Legal ID", "id.jpg");
//        userdata.put("Birth Certificate", "bdcertificate.pdf");
        mFirestore.collection("Service").document("PassportService").collection("change of passport date").document(userID).set(userdata).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(ChangeOfPassportData.this, "Document Successfully submitted", Toast.LENGTH_LONG).show();
                    //mProgressBar.setVisibility(View.GONE);
                    Intent intent = new Intent(ChangeOfPassportData.this, ChangeOfPassportData_Appointment.class);
                    startActivity(intent);
                    mProgressDialog.dismiss();

                } else {
                    Toast.makeText(ChangeOfPassportData.this, "Error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void fillArrayList() {
        ArrayAdapter<String> arrayAdapter_site;
        arrayList_site = new ArrayList<>();
        arrayList_site.add("Select Site Location");
        arrayList_site.add("Addis Abeba");
        arrayList_site.add("Dire Dawa");
        arrayList_site.add("Sidama");
        arrayList_site.add("Tigray");
        arrayList_site.add("Benishangul_Gumuz");
        arrayList_site.add("Amhara");
        arrayList_site.add("Oromia");
        arrayList_site.add("Afar");
        arrayList_site.add("Gambella");
        arrayList_site.add("Harari");
        arrayList_site.add("Somali");
        arrayList_site.add("Southern Nations Nationalities and People Region (SNNPR)");
        arrayAdapter_site = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_site);
        sp_site.setAdapter(arrayAdapter_site);

        arrayList_city = new ArrayList<>();
        arrayList_city.add("Select City");

        arrayList_AAcity = new ArrayList<>();
        arrayList_AAcity.add("Addis Abeba");

        arrayList_amharacity = new ArrayList<>();
        arrayList_amharacity.add("Bahir Dar");
        arrayList_amharacity.add("Dessie");

        arrayList_afarcity = new ArrayList<>();
        arrayList_afarcity.add("Samara");

        arrayList_benishangulgumuzcity = new ArrayList<>();
        arrayList_benishangulgumuzcity.add("Benishangul_Gumuz");

        arrayList_diredawacity = new ArrayList<>();
        arrayList_diredawacity.add("Dire Dawa");

        arrayList_oromiacity = new ArrayList<>();
        arrayList_oromiacity.add("Adama");
        arrayList_oromiacity.add("Jimma");

        arrayList_sidamacity = new ArrayList<>();
        arrayList_sidamacity.add("Hawassa");

        arrayList_tigraycity = new ArrayList<>();
        arrayList_tigraycity.add("Mekelle");

        arrayList_somalicity = new ArrayList<>();
        arrayList_somalicity.add("Jigjiga");

        arrayList_snnprcity = new ArrayList<>();
        arrayList_snnprcity.add("Hawassa");

        arrayList_office = new ArrayList<>();
        arrayList_office.add("Select Office");

        arrayList_AAoffice = new ArrayList<>();
        arrayList_AAoffice.add("Immigration Nationality and Vital Events Office");

        arrayList_bahirdaroffice = new ArrayList<>();
        arrayList_bahirdaroffice.add("Bahir Dar INVEA");

        arrayList_dessieoffice = new ArrayList<>();
        arrayList_dessieoffice.add("Dessie INVEA");

        arrayList_samaraoffice = new ArrayList<>();
        arrayList_samaraoffice.add("Samara INVEA");

        arrayList_benishangulgumuzoffice = new ArrayList<>();
        arrayList_benishangulgumuzoffice.add("Benishangul_Gumuz");

        arrayList_diredawaoffice = new ArrayList<>();
        arrayList_diredawaoffice.add("Dire Dawa INVEA");

        arrayList_adamaoffice = new ArrayList<>();
        arrayList_adamaoffice.add("Adama INVEA");

        arrayList_jimmaoffice = new ArrayList<>();
        arrayList_jimmaoffice.add("Jimma INVEA");

        arrayList_hawassaoffice = new ArrayList<>();
        arrayList_hawassaoffice.add("Hawassa INVEA");

        arrayList_mekelleoffice = new ArrayList<>();
        arrayList_mekelleoffice.add("Mekelle INVEA");

        arrayList_jigjigaoffice = new ArrayList<>();
        arrayList_jigjigaoffice.add("Jigjiga INVEA");

        arrayList_deliverysite = new ArrayList<>();
        arrayList_deliverysite.add("Select Delivery Site");

        arrayList_AAdeliverysite = new ArrayList<>();
        arrayList_AAdeliverysite.add("Main Post Office");

        arrayList_bahirdardeliverysite = new ArrayList<>();
        arrayList_bahirdardeliverysite.add("Bahir Dar Post Office");

        arrayList_dessiedeliverysite = new ArrayList<>();
        arrayList_dessiedeliverysite.add("Dessie Post Office");

        arrayList_samaradeliverysite = new ArrayList<>();
        arrayList_samaradeliverysite.add("Samara Post Office");

        arrayList_benishangulgumuzdeliverysite = new ArrayList<>();
        arrayList_benishangulgumuzdeliverysite.add("Benishangul_Gumuz");

        arrayList_diredawadeliverysite = new ArrayList<>();
        arrayList_diredawadeliverysite.add("Dire Dawa Post Offce");

        arrayList_adamadeliverysite = new ArrayList<>();
        arrayList_adamadeliverysite.add("Adama Post Office");

        arrayList_jimmadeliverysite = new ArrayList<>();
        arrayList_jimmadeliverysite.add("Jimma Post Office");

        arrayList_hawassadeliverysite = new ArrayList<>();
        arrayList_hawassadeliverysite.add("Hawassa Post Office");

        arrayList_mekelledeliverysite = new ArrayList<>();
        arrayList_mekelledeliverysite.add("Mekelle Post Office");

        arrayList_jigjigadeliverysite = new ArrayList<>();
        arrayList_jigjigadeliverysite.add("Main Post Office ");
    }

    private void itemSelectionListener() {
        if (sp_site.getSelectedItemPosition() == 0) {
            ArrayAdapter<String> arrayAdapter_city = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_city);
            sp_city.setAdapter(arrayAdapter_city);
            ArrayAdapter<String> arrayAdapter_office = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_office);
            sp_office.setAdapter(arrayAdapter_office);
            ArrayAdapter<String> arrayAdapter_deliverysite = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_deliverysite);
            sp_deliverysite.setAdapter(arrayAdapter_deliverysite);
        } else if (sp_site.getSelectedItemPosition() == 1) {
            sp_site_error_TV.setVisibility(View.GONE);
            ArrayAdapter<String> arrayAdapter_city = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_AAcity);
            sp_city.setAdapter(arrayAdapter_city);
            ArrayAdapter<String> arrayAdapter_office = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_AAoffice);
            sp_office.setAdapter(arrayAdapter_office);
            ArrayAdapter<String> arrayAdapter_deliverysite = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_AAdeliverysite);
            sp_deliverysite.setAdapter(arrayAdapter_deliverysite);
        } else if (sp_site.getSelectedItemPosition() == 2) {
            sp_site_error_TV.setVisibility(View.GONE);
            ArrayAdapter<String> arrayAdapter_city = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_diredawacity);
            sp_city.setAdapter(arrayAdapter_city);
            ArrayAdapter<String> arrayAdapter_office = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_diredawaoffice);
            sp_office.setAdapter(arrayAdapter_office);
            ArrayAdapter<String> arrayAdapter_deliverysite = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_diredawadeliverysite);
            sp_deliverysite.setAdapter(arrayAdapter_deliverysite);
        } else if (sp_site.getSelectedItemPosition() == 3) {
            sp_site_error_TV.setVisibility(View.GONE);
            ArrayAdapter<String> arrayAdapter_city = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_sidamacity);
            sp_city.setAdapter(arrayAdapter_city);
            ArrayAdapter<String> arrayAdapter_office = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_hawassaoffice);
            sp_office.setAdapter(arrayAdapter_office);
            ArrayAdapter<String> arrayAdapter_deliverysite = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_hawassadeliverysite);
            sp_deliverysite.setAdapter(arrayAdapter_deliverysite);
        } else if (sp_site.getSelectedItemPosition() == 4) {
            sp_site_error_TV.setVisibility(View.GONE);
            ArrayAdapter<String> arrayAdapter_city = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_tigraycity);
            sp_city.setAdapter(arrayAdapter_city);
            ArrayAdapter<String> arrayAdapter_office = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_mekelleoffice);
            sp_office.setAdapter(arrayAdapter_office);
            ArrayAdapter<String> arrayAdapter_deliverysite = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_mekelledeliverysite);
            sp_deliverysite.setAdapter(arrayAdapter_deliverysite);
        } else if (sp_site.getSelectedItemPosition() == 5) {
            sp_site_error_TV.setVisibility(View.GONE);
            ArrayAdapter<String> arrayAdapter_city = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_benishangulgumuzcity);
            sp_city.setAdapter(arrayAdapter_city);
            ArrayAdapter<String> arrayAdapter_office = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_benishangulgumuzoffice);
            sp_office.setAdapter(arrayAdapter_office);
            ArrayAdapter<String> arrayAdapter_deliverysite = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_benishangulgumuzdeliverysite);
            sp_deliverysite.setAdapter(arrayAdapter_deliverysite);
        } else if (sp_site.getSelectedItemPosition() == 6) {
            sp_site_error_TV.setVisibility(View.GONE);
            ArrayAdapter<String> arrayAdapter_city = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_amharacity);
            sp_city.setAdapter(arrayAdapter_city);
            if (sp_city.getSelectedItemPosition() == 0) {
                ArrayAdapter<String> arrayAdapter_office = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_bahirdaroffice);
                sp_office.setAdapter(arrayAdapter_office);
                ArrayAdapter<String> arrayAdapter_deliverysite = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_bahirdardeliverysite);
                sp_deliverysite.setAdapter(arrayAdapter_deliverysite);
            } else {
                ArrayAdapter<String> arrayAdapter_office = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_dessieoffice);
                sp_office.setAdapter(arrayAdapter_office);
                ArrayAdapter<String> arrayAdapter_deliverysite = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_dessiedeliverysite);
                sp_deliverysite.setAdapter(arrayAdapter_deliverysite);
            }
        } else if (sp_site.getSelectedItemPosition() == 7) {
            sp_site_error_TV.setVisibility(View.GONE);
            ArrayAdapter<String> arrayAdapter_city = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_oromiacity);
            sp_city.setAdapter(arrayAdapter_city);
            if (sp_city.getSelectedItemPosition() == 0) {
                ArrayAdapter<String> arrayAdapter_office = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_adamaoffice);
                sp_office.setAdapter(arrayAdapter_office);
                ArrayAdapter<String> arrayAdapter_deliverysite = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_adamadeliverysite);
                sp_deliverysite.setAdapter(arrayAdapter_deliverysite);
            } else {
                ArrayAdapter<String> arrayAdapter_office = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_jimmaoffice);
                sp_office.setAdapter(arrayAdapter_office);
                ArrayAdapter<String> arrayAdapter_deliverysite = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_jimmadeliverysite);
                sp_deliverysite.setAdapter(arrayAdapter_deliverysite);
            }
        } else if (sp_site.getSelectedItemPosition() == 8) {
            sp_site_error_TV.setVisibility(View.GONE);
            ArrayAdapter<String> arrayAdapter_city = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_afarcity);
            sp_city.setAdapter(arrayAdapter_city);
            ArrayAdapter<String> arrayAdapter_office = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_samaraoffice);
            sp_office.setAdapter(arrayAdapter_office);
            ArrayAdapter<String> arrayAdapter_deliverysite = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_samaradeliverysite);
            sp_deliverysite.setAdapter(arrayAdapter_deliverysite);
        } else if (sp_site.getSelectedItemPosition() == 9) {
            sp_site_error_TV.setVisibility(View.GONE);
            ArrayAdapter<String> arrayAdapter_city = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_city);
            sp_city.setAdapter(arrayAdapter_city);
            ArrayAdapter<String> arrayAdapter_office = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_office);
            sp_office.setAdapter(arrayAdapter_office);
            ArrayAdapter<String> arrayAdapter_deliverysite = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_deliverysite);
            sp_deliverysite.setAdapter(arrayAdapter_deliverysite);
        } else if (sp_site.getSelectedItemPosition() == 10) {
            sp_site_error_TV.setVisibility(View.GONE);
            ArrayAdapter<String> arrayAdapter_city = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_city);
            sp_city.setAdapter(arrayAdapter_city);
            ArrayAdapter<String> arrayAdapter_office = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_office);
            sp_office.setAdapter(arrayAdapter_office);
            ArrayAdapter<String> arrayAdapter_deliverysite = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_deliverysite);
            sp_deliverysite.setAdapter(arrayAdapter_deliverysite);
        } else if (sp_site.getSelectedItemPosition() == 11) {
            sp_site_error_TV.setVisibility(View.GONE);
            ArrayAdapter<String> arrayAdapter_city = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_city);
            sp_city.setAdapter(arrayAdapter_city);
            ArrayAdapter<String> arrayAdapter_office = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_office);
            sp_office.setAdapter(arrayAdapter_office);
            ArrayAdapter<String> arrayAdapter_deliverysite = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_deliverysite);
            sp_deliverysite.setAdapter(arrayAdapter_deliverysite);
        } else if (sp_site.getSelectedItemPosition() == 12) {
            sp_site_error_TV.setVisibility(View.GONE);
            ArrayAdapter<String> arrayAdapter_city = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_snnprcity);
            sp_city.setAdapter(arrayAdapter_city);
            ArrayAdapter<String> arrayAdapter_office = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_hawassaoffice);
            sp_office.setAdapter(arrayAdapter_office);
            ArrayAdapter<String> arrayAdapter_deliverysite = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, arrayList_hawassadeliverysite);
            sp_deliverysite.setAdapter(arrayAdapter_deliverysite);
        }
        String site = sp_site.getSelectedItem().toString();
        String city = sp_city.getSelectedItem().toString();
        String office = sp_office.getSelectedItem().toString();
        String deliverysite = sp_deliverysite.getSelectedItem().toString();
    }
}
