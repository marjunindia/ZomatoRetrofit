package com.example.arjun_mu.zomatoretrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

        private static final String BASE_URL = "https://developers.zomato.com";

        private static Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(BASE_URL);
 //.addConverterFactory(GsonConverterFactory.create()
        private static Retrofit retrofit = builder.build();

        private static HttpLoggingInterceptor logging =
                new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY);

        private static OkHttpClient.Builder httpClient =
                new OkHttpClient.Builder();

          private static AuthenticationInterceptor interceptor =
                    new AuthenticationInterceptor("c8e75be8258f06990d42e533b812e5a5");

        public static <S> S createService(
                Class<S> serviceClass) {
            if (!httpClient.interceptors().contains(logging)) {
                httpClient.addInterceptor(logging);
                httpClient.addInterceptor(interceptor);
                builder.client(httpClient.build());
                retrofit = builder.build();
            }

            return retrofit.create(serviceClass);
        }


}
