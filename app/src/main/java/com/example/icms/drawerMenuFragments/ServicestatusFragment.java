package com.example.icms.drawerMenuFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.icms.MainActivity;
import com.example.icms.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ServicestatusFragment extends Fragment {
    EditText checkvisastatuspasseno_ET, checkvisastatusreferenceno_ET, checkpassportstatusreferenceno_ET;
    Button checkevisasubmit_btn, checkpassportsubmit_btn;

    public ServicestatusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_servicestatus, container, false);
        checkvisastatuspasseno_ET = v.findViewById(R.id.checkvisastatuspasseno_ET);
        checkvisastatusreferenceno_ET = v.findViewById(R.id.checkvisastatusreferenceno_ET);
        checkpassportstatusreferenceno_ET = v.findViewById(R.id.checkpassportstatusreferenceno_ET);
        checkevisasubmit_btn = v.findViewById(R.id.checkevisasubmit_btn);
        checkpassportsubmit_btn = v.findViewById(R.id.checkpassportsubmit_btn);

        checkevisasubmit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkinputs();
            }
        });
        checkpassportsubmit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkinput();
            }
        });
        return v;
    }

    private void checkinputs() {
        String passportnumber = checkvisastatuspasseno_ET.getText().toString().trim();
        String referencenumber = checkvisastatusreferenceno_ET.getText().toString().trim();
        if (passportnumber.isEmpty()) {
            checkvisastatuspasseno_ET.setError("Enter your passport number!");
            checkvisastatuspasseno_ET.requestFocus();
        } else if (referencenumber.isEmpty()) {
            checkvisastatusreferenceno_ET.setError("Enter your passport number!");
            checkvisastatusreferenceno_ET.requestFocus();
        } else {
            Toast.makeText(getContext(), "Your visa process is about 50%. ", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getActivity(), MainActivity.class));
        }
    }

    private void checkinput() {
        String passportstatusreferencenumber = checkpassportstatusreferenceno_ET.getText().toString().trim();
        if (passportstatusreferencenumber.isEmpty()) {
            checkpassportstatusreferenceno_ET.setError("Enter your passport number!");
            checkpassportstatusreferenceno_ET.requestFocus();
        } else {
            Toast.makeText(getContext(), "Your passport process is about 90%. ", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getActivity(), MainActivity.class));
        }
    }
}
