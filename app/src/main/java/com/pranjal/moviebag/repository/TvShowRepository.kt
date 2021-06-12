package com.pranjal.moviebag.repository

import com.pranjal.moviebag.api.ApiService
import javax.inject.Inject

class TvShowRepository
@Inject
constructor(private val apiService: ApiService){

    suspend fun getTvShows()= apiService.getTvShows()
}