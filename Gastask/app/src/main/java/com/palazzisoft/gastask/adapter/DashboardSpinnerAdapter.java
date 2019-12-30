package com.palazzisoft.gastask.adapter;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.palazzisoft.gastask.R;
import com.palazzisoft.gastask.vo.Filter;

public class DashboardSpinnerAdapter extends ArrayAdapter<Filter> {

    private Context context;
    private List<Filter> filters;

    public DashboardSpinnerAdapter(Context context, int resource, List<Filter> filters) {
        super(context, resource, filters);
        this.filters = filters;
        this.context = context;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    private View getCustomView(int position, View convertView, ViewGroup parent) {
        final SpinnerViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.spinner_data, null);

            holder = new SpinnerViewHolder();
            holder.nameView = convertView.findViewById(R.id.spinner_text_id);
            holder.isCheckedView = convertView.findViewById(R.id.spinner_checked_id);

            if (position == 0) {
                holder.isCheckedView.setVisibility(View.INVISIBLE);
            }

            convertView.setTag(holder);
        } else {
            holder = (SpinnerViewHolder) convertView.getTag();
        }

        holder.nameView.setText(filters.get(position).getName());

        return convertView;
    }

    private class SpinnerViewHolder {
        private TextView nameView;
        private CheckBox isCheckedView;
    }
}
