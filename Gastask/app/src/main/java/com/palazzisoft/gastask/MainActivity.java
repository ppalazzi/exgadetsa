package com.palazzisoft.gastask;

import java.util.Arrays;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import com.palazzisoft.gastask.adapter.DashboardCustomerAdapter;

public class MainActivity extends AppCompatActivity {

    private DashboardCustomerAdapter dashboardCustomerAdapter;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleLarge);

        renderDashboardOptions();
    }

    private void renderDashboardOptions() {
        final String[] dashboardOptions = getResources().getStringArray(R.array.mainMenuOptions);

        recyclerView = findViewById(R.id.customRecyclerView);
        dashboardCustomerAdapter =
                new DashboardCustomerAdapter(Arrays.asList(dashboardOptions), getApplicationContext());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dashboardCustomerAdapter);
    }
}
