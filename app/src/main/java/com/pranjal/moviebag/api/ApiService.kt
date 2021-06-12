package com.pranjal.moviebag.api

import com.pranjal.moviebag.helper.Constants.END_POINT
import com.pranjal.moviebag.model.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(END_POINT)
    suspend fun getTvShows() : Response<TvShowResponse>
}