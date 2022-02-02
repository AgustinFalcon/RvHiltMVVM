package com.example.rvhiltretrofitmvvmagus.api

import com.example.rvhiltretrofitmvvmagus.helper.Constants
import com.example.rvhiltretrofitmvvmagus.models.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getTvShows(): Response<TvShowResponse>
}