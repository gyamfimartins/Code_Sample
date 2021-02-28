package com.gyamfimartins.sportsresults.api;

import com.google.gson.JsonObject;
import com.gyamfimartins.sportsresults.model.Sport;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SportApi {

    @Headers({"Content-Type: application/json", "Content-Length: 0"})
    @POST("results")
    Call<Sport> getSportResults();
}
