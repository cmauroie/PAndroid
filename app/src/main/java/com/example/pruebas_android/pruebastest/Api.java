package com.example.pruebas_android.pruebastest;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Pruebas-Android on 15/02/2018.
 */

public interface Api {
    @POST("connectionRest")
    Call<ModelDataResponse> getNews(@Query("getNews") String getNews);
}
