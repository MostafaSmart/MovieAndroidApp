package com.smartherd.namenewproject.data.retrofit

import com.smartherd.namenewproject.data.response.MovesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MovesApi {

    @GET("movie")
    fun getAllMoves(@Header("Content-Type") contentType: String,
                    @Header("Authorization") authorization: String): Call<MovesResponse>

//    @GET("filter.php?")
//    fun getMealsByCategory(@Query("i") category:String): Call<MealsResponse>
//
//    @GET("random.php")
//    fun getRandomMeal(): Call<RandomMealResponse>
//
//    @GET("lookup.php?")
//    fun getMealById(@Query("i") id:String): Call<RandomMealResponse>
//
//    @GET("search.php?")
//    fun getMealByName(@Query("s") s:String): Call<RandomMealResponse>
}