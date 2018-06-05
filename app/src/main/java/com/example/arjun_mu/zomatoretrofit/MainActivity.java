package com.example.arjun_mu.zomatoretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.arjun_mu.zomatoretrofit.model.Category;
import com.example.arjun_mu.zomatoretrofit.model.CategoryMain;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CatogoriesClient catogoriesClient = ServiceGenerator.createService(CatogoriesClient.class);

        catogoriesClient.getCategories().enqueue(new Callback<CategoryMain>() {
            @Override
            public void onResponse(Call<CategoryMain> call, Response<CategoryMain> response) {

                CategoryMain example = response.body();

                List<Category> categoryList = example.getCategories();

                for (int i = 0; i < categoryList.size(); i++) {
                    categoryList.get(i).getCategories().getId();

                }

            }

            @Override
            public void onFailure(Call<CategoryMain> call, Throwable t) {

            }
        });

    }
}
