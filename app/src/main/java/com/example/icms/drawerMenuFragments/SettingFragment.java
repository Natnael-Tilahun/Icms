package com.example.icms.drawerMenuFragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.icms.R;

public class SettingFragment extends Fragment {
    TextView changeusername_tv, changeemail_tv, changepassword_tv, changephone_tv, changeprofilepic_tv;
    Button changeusernamedialogsave_btn, changeusernamedialogcancel_btn;
    Button changeemaildialogsave_btn, changeemaildialogcancel_btn;
    Button changephonedialogsave_btn, changephonedialogcancel_btn;
    Button changeprofilepicturesave_btn, getChangeprofilepicturecancel_btn;
    Button changepasswordsave_btn, changepasswordcancel_btn;
    ImageView profile_iv;
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
        changeusername_tv = v.findViewById(R.id.changefullname_tv);
        changeemail_tv = v.findViewById(R.id.changeemail_tv);
        changepassword_tv = v.findViewById(R.id.chanegpaassword_tv);
        changephone_tv = v.findViewById(R.id.changephone_tv);
        changeprofilepic_tv = v.findViewById(R.id.changeprofilepic_tv);

        profile_iv = v.findViewById(R.id.profile_iv);

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
//                final Dialog dialog = new Dialog(getContext());
//                dialog.setContentView(R.layout.changeprofilepic_dialog);
//                dialog.setCanceledOnTouchOutside(false);
//                dialog.show();
                Intent OpenIntentGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(OpenIntentGallery, 1000);
            }
        });

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Uri imageUri = data.getData();
            profile_iv.setImageURI(imageUri);
        }
    }
}
