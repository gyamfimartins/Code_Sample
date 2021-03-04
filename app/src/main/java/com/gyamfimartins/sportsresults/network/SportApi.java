package com.gyamfimartins.sportsresults.network;

import com.gyamfimartins.sportsresults.model.Sport;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SportApi {

    @Headers({"Content-Type: application/json"})
    @POST("results")
    Call<Sport> getSportResults();
}
