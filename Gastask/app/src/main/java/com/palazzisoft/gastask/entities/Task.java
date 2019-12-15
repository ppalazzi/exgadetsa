package com.palazzisoft.gastask.entities;

import com.google.gson.annotations.SerializedName;

public class Task {

    @SerializedName("id")
    private String id;

    @SerializedName("jobType")
    private String jobType;

    @SerializedName("reasonCode")
    private String reasonCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

}