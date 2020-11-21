package com.example.icms.passportrequirement_recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.icms.R;

import java.util.ArrayList;
import java.util.List;

public class PassportRequirement extends AppCompatActivity {
    RecyclerView mRecyclerView;
    List<PassRequirementmModel> mPassRequirementmModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passport_requirement);

        mRecyclerView = findViewById(R.id.passrequirment_recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new PassportRequirement_Adapter(initData()));
    }

    private List<PassRequirementmModel> initData() {
        mPassRequirementmModelList = new ArrayList<>();
        mPassRequirementmModelList.add(new PassRequirementmModel(getString(R.string.passport_requirement_title_one), getString(R.string.passport_requirement_description_one)));
        mPassRequirementmModelList.add(new PassRequirementmModel(getString(R.string.passport_requirement_title_two), getString(R.string.passport_requirement_description_two)));
        mPassRequirementmModelList.add(new PassRequirementmModel(getString(R.string.passport_requirement_title_three), getString(R.string.passport_requirement_description_three)));
        mPassRequirementmModelList.add(new PassRequirementmModel(getString(R.string.passport_requirement_title_eleven), getString(R.string.passport_requirement_description_eleven)));
        mPassRequirementmModelList.add(new PassRequirementmModel(getString(R.string.passport_requirement_title_twelve), getString(R.string.passport_requirement_description_twelve)));
        mPassRequirementmModelList.add(new PassRequirementmModel(getString(R.string.passport_requirement_title_four), getString(R.string.passport_requirement_description_four)));
        mPassRequirementmModelList.add(new PassRequirementmModel(getString(R.string.passport_requirement_title_five), getString(R.string.passport_requirement_description_five)));
        mPassRequirementmModelList.add(new PassRequirementmModel(getString(R.string.passport_requirement_title_six), getString(R.string.passport_requirement_description_six)));
        mPassRequirementmModelList.add(new PassRequirementmModel(getString(R.string.passport_requirement_title_seven), getString(R.string.passport_requirement_description_seven)));
        mPassRequirementmModelList.add(new PassRequirementmModel(getString(R.string.passport_requirement_title_eight), getString(R.string.passport_requirement_description_eight)));
        mPassRequirementmModelList.add(new PassRequirementmModel(getString(R.string.passport_requirement_title_thirteen), getString(R.string.passport_requirement_description_thirteen)));
        mPassRequirementmModelList.add(new PassRequirementmModel(getString(R.string.passport_requirement_title_nine), getString(R.string.passport_requirement_description_nine)));

        return mPassRequirementmModelList;
    }
}