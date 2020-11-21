package com.example.icms.passportrequirement_recyclerview;

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

public class PassportRequirement_Adapter extends RecyclerView.Adapter<PassportRequirement_Adapter.RequirementVH> {
    List<PassRequirementmModel> mPassRequirementmModelList;

    public PassportRequirement_Adapter(List<PassRequirementmModel> passRequirementmModelList) {
        mPassRequirementmModelList = passRequirementmModelList;
    }

    @NonNull
    @Override
    public RequirementVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.passrequirement_row, parent, false);
        return new RequirementVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RequirementVH holder, int position) {
        PassRequirementmModel passRequirementmModel = mPassRequirementmModelList.get(position);
        holder.requirement_title.setText(passRequirementmModel.getRequirement_title());
        holder.requirement_description.setText(passRequirementmModel.getRequirement_description());
        boolean isExpandable = mPassRequirementmModelList.get(position).isExpandable();
        holder.requir_expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return mPassRequirementmModelList.size();
    }

    public class RequirementVH extends RecyclerView.ViewHolder {
        TextView requirement_title, requirement_description;
        LinearLayout requir_linearLayout;
        RelativeLayout requir_expandableLayout;

        public RequirementVH(@NonNull View itemView) {
            super(itemView);
            requirement_title = itemView.findViewById(R.id.requir_title);
            requirement_description = itemView.findViewById(R.id.requir_description);
            requir_linearLayout = itemView.findViewById(R.id.passrequir_linear_layout);
            requir_expandableLayout = itemView.findViewById(R.id.passrequir_expandable_layout);

            requir_linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PassRequirementmModel passRequirementmModel = mPassRequirementmModelList.get(getAdapterPosition());
                    passRequirementmModel.setExpandable(!passRequirementmModel.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
