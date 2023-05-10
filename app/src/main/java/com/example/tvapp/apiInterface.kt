package com.example.tvapp

import retrofit2.Call
import retrofit2.http.GET

interface apiInterface {

    @GET("platform/links")
    fun getLinks(): Call<mylink>
}