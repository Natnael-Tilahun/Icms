package com.example.icms.faq_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.icms.R;

import java.util.ArrayList;
import java.util.List;


public class FaqFragment extends Fragment {
    RecyclerView mRecyclerView;
    List<FaqModel> mFaqModelList;

    public FaqFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_faq, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new faqAdapter(initData()));
        return view;
    }

    private List<FaqModel> initData() {
        mFaqModelList = new ArrayList<>();
        mFaqModelList.add(new FaqModel(getString(R.string.faq_title_one), getString(R.string.faq_description_one)));
        mFaqModelList.add(new FaqModel(getString(R.string.faq_title_two), getString(R.string.faq_description_two)));
        mFaqModelList.add(new FaqModel(getString(R.string.faq_title_three), getString(R.string.faq_description_three)));
        mFaqModelList.add(new FaqModel(getString(R.string.faq_title_four), getString(R.string.faq_description_four)));
        mFaqModelList.add(new FaqModel(getString(R.string.faq_title_five), getString(R.string.faq_description_five)));
        mFaqModelList.add(new FaqModel(getString(R.string.faq_title_six), getString(R.string.faq_description_six)));
        mFaqModelList.add(new FaqModel(getString(R.string.faq_title_seven), getString(R.string.faq_description_seven)));
        mFaqModelList.add(new FaqModel(getString(R.string.faq_title_eight), getString(R.string.faq_description_eight)));
        mFaqModelList.add(new FaqModel(getString(R.string.faq_title_nine), getString(R.string.faq_description_nine)));
        mFaqModelList.add(new FaqModel(getString(R.string.faq_title_ten), getString(R.string.faq_description_ten)));
        mFaqModelList.add(new FaqModel(getString(R.string.faq_title_eleven), getString(R.string.faq_description_eleven)));
        mFaqModelList.add(new FaqModel(getString(R.string.faq_title_twelve), getString(R.string.faq_description_twelve)));
        mFaqModelList.add(new FaqModel(getString(R.string.faq_title_thirteen), getString(R.string.faq_description_thirteen)));
        mFaqModelList.add(new FaqModel(getString(R.string.faq_title_fourteen), getString(R.string.faq_description_fourteen)));

        return mFaqModelList;
    }


}