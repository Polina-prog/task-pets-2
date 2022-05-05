package com.example.pets

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRequests {
    @GET("breeds/image/random/11")
    suspend fun getBreeds(): Response<Repo>

    @GET("breed/{breed}/images/random")
    suspend fun getImage(@Path("breed") breed:String): Response<Repo2>
}