package com.palazzisoft.gastask.services;

import com.palazzisoft.gastask.entities.Task;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("/services/task")
    Call<Task> getSingleTask();
}
