package com.example.arjun_mu.zomatoretrofit;

import com.example.arjun_mu.zomatoretrofit.model.CategoryMain;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatogoriesClient {

    @GET("/api/v2.1/categories")
    Call<CategoryMain> getCategories();

}
