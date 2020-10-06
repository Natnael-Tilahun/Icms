package com.example.icms;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private CardView passcard, visacard, loccard, infocard;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        passcard = v.findViewById(R.id.passcard);
        visacard = v.findViewById(R.id.visacard);
        loccard = v.findViewById(R.id.locationcard);
        infocard = v.findViewById(R.id.informationcard);
        passcard.setOnClickListener(this);
        visacard.setOnClickListener(this);
        loccard.setOnClickListener(this);
        infocard.setOnClickListener(this);
//        passcard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            }
//        });
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.passcard:
                startActivity(new Intent(getActivity(), PassportServices.class));
                break;
            case R.id.visacard:
                startActivity(new Intent(getActivity(), VisaServices.class));
                break;
            case R.id.locationcard:
                MapsFragment fragment = new MapsFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragment);
                transaction.commit();

                break;
            case R.id.informationcard:
                startActivity(new Intent(getActivity(), GetInformation.class));
                break;

        }
    }

}
