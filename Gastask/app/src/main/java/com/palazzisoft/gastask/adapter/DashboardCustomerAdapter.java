package com.palazzisoft.gastask.adapter;

import java.util.List;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.palazzisoft.gastask.R;

public class DashboardCustomerAdapter extends RecyclerView.Adapter<DashboardCustomerAdapter.DashboardCustomViewHolder> {

    private List<String> options;
    private Context context;

    public DashboardCustomerAdapter(List<String> options, Context context) {
        this.options = options;
        this.context = context;
    }

    @NonNull
    @Override
    public DashboardCustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_dashboard, parent, false);
        return new DashboardCustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardCustomViewHolder dashboardCustomViewHolder, int i) {
        dashboardCustomViewHolder.getTextOption().setText(options.get(i));
        //Picasso.with(context).load(R.drawable.dashboardtodas).into(dashboardCustomViewHolder.getIconOption());
    }

    @Override
    public int getItemCount() {
        return options.size();
    }

    public class DashboardCustomViewHolder extends RecyclerView.ViewHolder {

        private TextView textOption;
        private ImageView iconOption;

        public DashboardCustomViewHolder(@NonNull View itemView) {
            super(itemView);

            textOption = itemView.findViewById(R.id.textDashboard);
            iconOption = itemView.findViewById(R.id.iconDashboard);
        }

        public TextView getTextOption() {
            return textOption;
        }

        public void setTextOption(TextView textOption) {
            this.textOption = textOption;
        }

        public ImageView getIconOption() {
            return iconOption;
        }

        public void setIconOption(ImageView iconOption) {
            this.iconOption = iconOption;
        }
    }

}
