package com.example.icms.visarequirement_recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.icms.R;

import java.util.ArrayList;
import java.util.List;

public class VisaRequirements extends AppCompatActivity {
    RecyclerView mRecyclerView;
    List<VisaRequirementModel> mVisaRequirementModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visa_requirements);

        mRecyclerView = findViewById(R.id.visarequirement_recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new VisaRequirementAdapter(initData()));
    }

    private List<VisaRequirementModel> initData() {
        mVisaRequirementModelList = new ArrayList<>();
        mVisaRequirementModelList.add(new VisaRequirementModel(
                getString(R.string.visa_requirement_title_one), getString(R.string.visa_requirement_description_one)));
        mVisaRequirementModelList.add(new VisaRequirementModel(getString(R.string.visa_requirement_title_two), getString(R.string.visa_requirement_description_two)));
        mVisaRequirementModelList.add(new VisaRequirementModel(getString(R.string.visa_requirement_title_three), getString(R.string.visa_requirement_description_three)));
        mVisaRequirementModelList.add(new VisaRequirementModel(getString(R.string.visa_requirement_title_four), getString(R.string.visa_requirement_description_four)));
        mVisaRequirementModelList.add(new VisaRequirementModel(getString(R.string.visa_requirement_title_five), getString(R.string.visa_requirement_description_five)));
        mVisaRequirementModelList.add(new VisaRequirementModel(getString(R.string.visa_requirement_title_six), getString(R.string.visa_requirement_description_six)));
        mVisaRequirementModelList.add(new VisaRequirementModel(getString(R.string.visa_requirement_title_seven), getString(R.string.visa_requirement_description_seven)));
        mVisaRequirementModelList.add(new VisaRequirementModel(getString(R.string.visa_requirement_title_eight), getString(R.string.visa_requirement_description_eight)));
        mVisaRequirementModelList.add(new VisaRequirementModel(getString(R.string.visa_requirement_title_nine), getString(R.string.visa_requirement_description_nine)));
        mVisaRequirementModelList.add(new VisaRequirementModel(getString(R.string.visa_requirement_title_ten), getString(R.string.visa_requirement_description_ten)));
        mVisaRequirementModelList.add(new VisaRequirementModel(getString(R.string.visa_requirement_title_eleven), getString(R.string.visa_requirement_description_eleven)));
        mVisaRequirementModelList.add(new VisaRequirementModel(getString(R.string.visa_requirement_title_twelve), getString(R.string.visa_requirement_description_twelve)));
        mVisaRequirementModelList.add(new VisaRequirementModel(getString(R.string.visa_requirement_title_thirteen), getString(R.string.visa_requirement_description_thirteen)));
        mVisaRequirementModelList.add(new VisaRequirementModel(getString(R.string.visa_requirement_title_fourteen), getString(R.string.visa_requirement_description_fourteen)));

        return mVisaRequirementModelList;
    }
}