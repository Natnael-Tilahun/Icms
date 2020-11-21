package com.example.icms.servicefees_recyclerview;

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

public class ServiceFeeAdapter extends RecyclerView.Adapter<ServiceFeeAdapter.ServiceFeeVH> {
    List<ServiceFeeModel> mServiceFeeModelList;

    public ServiceFeeAdapter(List<ServiceFeeModel> serviceFeeModelList) {
        mServiceFeeModelList = serviceFeeModelList;
    }

    @NonNull
    @Override
    public ServiceFeeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.servicefees_row, parent, false);
        return new ServiceFeeVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceFeeVH holder, int position) {
        ServiceFeeModel serviceFeeModel = mServiceFeeModelList.get(position);
        holder.servicefees_title.setText(serviceFeeModel.getServicefee_title());
        holder.servicefees_description.setText(serviceFeeModel.getServicefee_description());
        boolean isExpandable = mServiceFeeModelList.get(position).isExpandable();
        holder.servicefees_expandablelayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return mServiceFeeModelList.size();
    }

    public class ServiceFeeVH extends RecyclerView.ViewHolder {
        TextView servicefees_title, servicefees_description;
        LinearLayout servicefees_linearlayout;
        RelativeLayout servicefees_expandablelayout;

        public ServiceFeeVH(@NonNull View itemView) {
            super(itemView);
            servicefees_title = itemView.findViewById(R.id.servicefee_title);
            servicefees_description = itemView.findViewById(R.id.servicefee_description);
            servicefees_linearlayout = itemView.findViewById(R.id.servicefees_linear_layout);
            servicefees_expandablelayout = itemView.findViewById(R.id.servicefee_expandable_layout);

            servicefees_linearlayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ServiceFeeModel serviceFeeModel = mServiceFeeModelList.get(getAdapterPosition());
                    serviceFeeModel.setExpandable(!serviceFeeModel.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
