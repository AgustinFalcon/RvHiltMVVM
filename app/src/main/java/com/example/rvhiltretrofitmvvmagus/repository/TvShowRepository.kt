package com.example.rvhiltretrofitmvvmagus.repository

import com.example.rvhiltretrofitmvvmagus.api.ApiService
import javax.inject.Inject

class TvShowRepository @Inject constructor(private val apiService: ApiService){

    suspend fun getTvShow() = apiService.getTvShows()

}