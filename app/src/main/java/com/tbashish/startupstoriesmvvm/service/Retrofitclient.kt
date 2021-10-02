package com.tbashish.startupstoriesmvvm.service

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

public class RetrofitClient {

    public fun getInstance() : Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://www.karostartup.com/wp-json/wp/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // why is this used?
                .build()
    }
}
