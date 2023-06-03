package com.remote

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class RetrofitService {
    var retrofit = Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com")
        .addConverterFactory(GsonConverterFactory.create()).build()

    var api = retrofit.create(LoveApi::class.java)
}