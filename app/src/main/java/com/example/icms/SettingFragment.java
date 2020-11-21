package com.example.icms;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SettingFragment extends Fragment {
    TextView changeusername_tv, changeemail_tv, changepassword_tv, changephone_tv, changeprofilepic_tv;
    Button changeusernamedialogsave_btn, changeusernamedialogcancel_btn;
    Button changeemaildialogsave_btn, changeemaildialogcancel_btn;
    Button changephonedialogsave_btn, changephonedialogcancel_btn;
    Button changeprofilepicturesave_btn, getChangeprofilepicturecancel_btn;
    Button changepasswordsave_btn, changepasswordcancel_btn;
    SettingFragment mContext;
    Dialog mDialog;

    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_setting, container, false);
        changeusername_tv = v.findViewById(R.id.changeusername_tv);
        changeemail_tv = v.findViewById(R.id.changeemail_tv);
        changepassword_tv = v.findViewById(R.id.chanegpaassword_tv);
        changephone_tv = v.findViewById(R.id.changephone_tv);
        changeprofilepic_tv = v.findViewById(R.id.changeprofilepic_tv);

        changeusernamedialogsave_btn = v.findViewById(R.id.changeusernamedialogsave_btn);
        changeusernamedialogcancel_btn = v.findViewById(R.id.changeusernamedialogcancel_btn);

        changeemaildialogsave_btn = v.findViewById(R.id.changeemaildialogsave_btn);
        changeemaildialogcancel_btn = v.findViewById(R.id.changeemaildialogcancel_btn);

        changephonedialogsave_btn = v.findViewById(R.id.changephonedialogsave_btn);
        changephonedialogcancel_btn = v.findViewById(R.id.changephonedialogcancel_btn);

        //username setting dialog
        changeusername_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.changeusername_dialog);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        });

        //phone setting dialog
        changephone_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog = new Dialog(getContext());
                mDialog.setContentView(R.layout.changephone_dialog);
                mDialog.setCanceledOnTouchOutside(false);
                mDialog.show();
//                changephonedialogcancel_btn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        mDialog.dismiss();
//                    }
//                });
            }
        });

//        changephonedialogcancel_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mDialog.dismiss();
//            }
//        });
        //change username
//        changeusername_tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mDialog.show();
//            }
//        });
//        //change username save button
////        changeemaildialogsave_btn.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Toast.makeText(getActivity(),"save",Toast.LENGTH_SHORT).show();
////                dialog.dismiss();
////            }
////        });
//        //change username cancel button
////        changeusernamedialogcancel_btn.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                dialog.dismiss();
////            }
////        });
//
//        //change email

        //email setting dialog listener
        changeemail_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.changeemail_dialog);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();

            }
        });
        //change email save button
        //change email cancel button

        //change password

        //password setting dialog
        changepassword_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.changepassword_dialog);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        });

        //change phone
//        changephone_tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final Dialog dialog=new Dialog(getContext());
//                dialog.setContentView(R.layout.changephone_dialog);
//                dialog.setCanceledOnTouchOutside(false);
//
//            }
//        });

        //change profile picture

        //profile picture dialog
        changeprofilepic_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.changeprofilepic_dialog);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        });

        return v;
    }
}
