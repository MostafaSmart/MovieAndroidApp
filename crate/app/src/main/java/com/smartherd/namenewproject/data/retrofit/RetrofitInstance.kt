package com.smartherd.namenewproject.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val movesApi:MovesApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/discover/movie/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovesApi::class.java)
    }
}