package com.example.icms;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    CardView passcard, visacard, loccard, infocard;
    TextView smsCountText;
    int pendingSmsCount = 10;

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
        setHasOptionsMenu(true);
        return v;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull final Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.notification_menu, menu);
        menu.findItem(R.menu.notification_menu);
        final FrameLayout actionView = (FrameLayout) menu.findItem(R.id.notification_nav).getActionView();
        smsCountText = actionView.findViewById(R.id.notification_badge_tv);
        setUpBadge();

        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                onOptionsItemSelected(menuItem);
                startActivity(new Intent(getActivity(), Notification.class));
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId())
//        {
//            case R.id.notification_nav:{
//                startActivity(new Intent(getActivity(),Notification.class));
//                break;
//            }
//            default: return super.onOptionsItemSelected(item);
//        }
//
//        return true;
//    }

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
                startActivity(new Intent(getActivity(), GetLocation.class));
                break;
            case R.id.informationcard:
                startActivity(new Intent(getActivity(), GetInformation.class));
                break;

        }
    }

    private void setUpBadge() {
        if (smsCountText != null) {
            if (pendingSmsCount == 0) {
                if (smsCountText.getVisibility() != View.GONE) {
                    smsCountText.setVisibility(View.GONE);
                } else {
                    smsCountText.setText(String.valueOf(Math.min(pendingSmsCount, 99)));
                    if (smsCountText.getVisibility() != View.VISIBLE) {
                        smsCountText.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
    }

}
