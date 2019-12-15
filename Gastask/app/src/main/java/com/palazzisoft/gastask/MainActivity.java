package com.palazzisoft.gastask;

import java.io.IOException;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.palazzisoft.gastask.entities.Task;
import com.palazzisoft.gastask.services.APIClient;
import com.palazzisoft.gastask.services.APIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private APIService apiService;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textId);

        apiService = APIClient.getClient().create(APIService.class);

        Call<Task> tasks = apiService.getSingleTask();

        tasks.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(Call<Task> call, Response<Task> response) {
                Task task = response.body();
                textView.setText(task.getReasonCode());
            }

            @Override
            public void onFailure(Call<Task> call, Throwable t) {
                Log.e("MainActivity", t.getMessage());
            }
        });
    }
}
