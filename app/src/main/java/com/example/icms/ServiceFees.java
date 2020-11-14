package com.example.icms;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ServiceFees extends AppCompatActivity {
    RecyclerView mRecyclerView;
    List<ServiceFeeModel> mServiceFeeModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_fees);

        mRecyclerView = findViewById(R.id.servicefees_recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new ServiceFeeAdapter(initData()));
    }

    private List<ServiceFeeModel> initData() {
        mServiceFeeModelList = new ArrayList<>();
        mServiceFeeModelList.add(new ServiceFeeModel(getString(R.string.ethiopian_new_passport_fee_title), getString(R.string.ethiopian_new_passport_fee_description)));
        mServiceFeeModelList.add(new ServiceFeeModel(getString(R.string.expired_passport_fee_title), getString(R.string.expired_passport_fee_description)));
        mServiceFeeModelList.add(new ServiceFeeModel(getString(R.string.passport_page_run_out_fee_title), getString(R.string.passport_page_run_out_fee_description)));
        mServiceFeeModelList.add(new ServiceFeeModel(getString(R.string.damaged_passport_fee_title), getString(R.string.damaged_passport_fee_description)));
        mServiceFeeModelList.add(new ServiceFeeModel(getString(R.string.lost_passport_fee_title), getString(R.string.lost_passport_fee_description)));
        mServiceFeeModelList.add(new ServiceFeeModel(getString(R.string.Valid_passport_fee_title), getString(R.string.Valid_passport_fee_description)));
        mServiceFeeModelList.add(new ServiceFeeModel(getString(R.string.online_tourist_visa_fee_title), getString(R.string.online_tourist_visa_fee_description)));
        mServiceFeeModelList.add(new ServiceFeeModel(getString(R.string.journalist_visa_fee_title), getString(R.string.journalist_visa_fee_description)));
        mServiceFeeModelList.add(new ServiceFeeModel(getString(R.string.international_organizations_embassies_work_visa_ri_fee_title), getString(R.string.international_organizations_embassies_work_visa_ri_fee_description)));
        mServiceFeeModelList.add(new ServiceFeeModel(getString(R.string.investment_visa_iv_fee_title), getString(R.string.investment_visa_iv_fee_description)));
        mServiceFeeModelList.add(new ServiceFeeModel(getString(R.string.ethiopian_government_institutions_short_task_visa_giv_fee_title), getString(R.string.ethiopian_government_institutions_short_task_visa_giv_fee_description)));
        mServiceFeeModelList.add(new ServiceFeeModel(getString(R.string.non_governmental_organizations_ngo_work_visa_nv_fee_title), getString(R.string.non_governmental_organizations_ngo_work_visa_nv_fee_description)));
        mServiceFeeModelList.add(new ServiceFeeModel(getString(R.string.conference_visa_cv_fee_title), getString(R.string.conference_visa_cv_fee_description)));
        mServiceFeeModelList.add(new ServiceFeeModel(getString(R.string.ethiopian_government_employment_visa_gv_fee_title), getString(R.string.ethiopian_government_employment_visa_gv_fee_description)));
        mServiceFeeModelList.add(new ServiceFeeModel(getString(R.string.foreign_business_firm_employment_visa_wv_fee_title), getString(R.string.foreign_business_firm_employment_visa_wv_fee_description)));
        mServiceFeeModelList.add(new ServiceFeeModel(getString(R.string.ethiopian_private_business_firm_work_visa_pe_fee_title), getString(R.string.ethiopian_private_business_firm_work_visa_pe_fee_description)));
        mServiceFeeModelList.add(new ServiceFeeModel(getString(R.string.visa_extension_fee_title), getString(R.string.visa_extension_fee_description)));


        return mServiceFeeModelList;
    }
}