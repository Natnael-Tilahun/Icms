package com.example.icms.faq_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.icms.R;

import java.util.List;

public class faqAdapter extends RecyclerView.Adapter<faqAdapter.VersionVH> {

    List<FaqModel> mFaqModelList;

    public faqAdapter(List<FaqModel> faqModelList) {
        mFaqModelList = faqModelList;
    }

    @NonNull
    @Override
    public VersionVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.faq_row, parent, false);
        return new VersionVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VersionVH holder, int position) {
        FaqModel faqModel = mFaqModelList.get(position);
        holder.titletv.setText(faqModel.getInfo_title());
        holder.descriptiontv.setText(faqModel.getInfo_description());

        boolean isExpandable = mFaqModelList.get(position).isExpandable();
        holder.expandbleLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return mFaqModelList.size();
    }

    public class VersionVH extends RecyclerView.ViewHolder {
        TextView titletv, descriptiontv;
        LinearLayout mLinearLayout;
        RelativeLayout expandbleLayout;

        public VersionVH(@NonNull View itemView) {
            super(itemView);
            titletv = itemView.findViewById(R.id.info_title);
            descriptiontv = itemView.findViewById(R.id.info_description);
            mLinearLayout = itemView.findViewById(R.id.faqrow_linear_layout);
            expandbleLayout = itemView.findViewById(R.id.faqrow_expandable_layout);

            mLinearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FaqModel faqModel = mFaqModelList.get(getAdapterPosition());
                    faqModel.setExpandable(!faqModel.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
