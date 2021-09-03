package ru.axout.mvvm_colorguide.network;

import retrofit2.http.GET;

public interface ICall {

    @GET("flowers")
    retrofit2.Call<FlowerResponse> getAllFlowers();
}
