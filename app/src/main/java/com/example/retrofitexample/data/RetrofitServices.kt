package com.example.retrofitexample.data

import com.example.retrofitexample.data.SampleJsonDataModel
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitServices {

    @GET("/posts")
    suspend fun getAllPosts(): Response<SampleJsonDataModel>
}