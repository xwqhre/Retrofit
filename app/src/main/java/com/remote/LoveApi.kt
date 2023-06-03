package com.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun getPercentage(
        @Query("fname")firstName: String,
        @Query("sname")secondName: String,
        @Header("X-RapidAPI-Key") key: String = "f295737073msh817ead3ada613b6p12c01fjsn766baf839c33",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ) : Call<LoveModel>
}