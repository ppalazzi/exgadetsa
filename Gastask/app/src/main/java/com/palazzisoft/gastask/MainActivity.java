package com.palazzisoft.gastask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.Spinner;
import com.palazzisoft.gastask.adapter.DashboardCustomerAdapter;
import com.palazzisoft.gastask.adapter.DashboardSpinnerAdapter;
import com.palazzisoft.gastask.vo.Filter;

public class MainActivity extends AppCompatActivity {

    private DashboardCustomerAdapter dashboardCustomerAdapter;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleLarge);
        toolbar = findViewById(R.id.dashboardToolbar);
        spinner = findViewById(R.id.filterTaskId);

        setSupportActionBar(toolbar);
        renderViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    private void renderViews() {
        renderDashboardOptions();
        renderFilterOptions();
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

    private void renderFilterOptions() {
        List<Filter> filtersOptions = buildFiltersFromResourcesOptions();

        DashboardSpinnerAdapter spinnerAdapter = new DashboardSpinnerAdapter(this, 0, filtersOptions);
        spinner.setAdapter(spinnerAdapter);
    }

    private List<Filter> buildFiltersFromResourcesOptions() {
        final String[] filterOptionsLabels = getResources().getStringArray(R.array.filters);

        List<Filter> filters = new ArrayList<>();
        for (String name : filterOptionsLabels) {
            filters.add(new Filter(name));
        }

        return filters;
    }
}
