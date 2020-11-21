package com.example.icms.visarequirement_recyclerview;

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

public class VisaRequirementAdapter extends RecyclerView.Adapter<VisaRequirementAdapter.VisaRequirementVH> {
    List<VisaRequirementModel> mVisaRequirementModelList;

    public VisaRequirementAdapter(List<VisaRequirementModel> visaRequirementModelList) {
        mVisaRequirementModelList = visaRequirementModelList;
    }

    @NonNull
    @Override
    public VisaRequirementAdapter.VisaRequirementVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.visarequirement_row, parent, false);
        return new VisaRequirementVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VisaRequirementAdapter.VisaRequirementVH holder, int position) {
        VisaRequirementModel visaRequirementModel = mVisaRequirementModelList.get(position);
        holder.visarequir_title.setText(visaRequirementModel.getVisarequir_title());
        holder.visarquir_description.setText(visaRequirementModel.getVisarequir_description());
        boolean isExpandable = mVisaRequirementModelList.get(position).isExpandable();
        holder.visarequir_expandablelayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return mVisaRequirementModelList.size();
    }

    public class VisaRequirementVH extends RecyclerView.ViewHolder {
        TextView visarequir_title, visarquir_description;
        LinearLayout visarequir_linrearlayout;
        RelativeLayout visarequir_expandablelayout;

        public VisaRequirementVH(@NonNull View itemView) {
            super(itemView);
            visarequir_title = itemView.findViewById(R.id.visarequir_title);
            visarquir_description = itemView.findViewById(R.id.visarequir_description);
            visarequir_linrearlayout = itemView.findViewById(R.id.visarequir_linear_layout);
            visarequir_expandablelayout = itemView.findViewById(R.id.visarequir_expandable_layout);
            visarequir_linrearlayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    VisaRequirementModel visaRequirementModel = mVisaRequirementModelList.get(getAdapterPosition());
                    visaRequirementModel.setExpandable(!visaRequirementModel.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
