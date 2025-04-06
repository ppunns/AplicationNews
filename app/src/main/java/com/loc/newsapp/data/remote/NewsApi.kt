package com.loc.newsapp.data.remote.dto

import com.loc.newsapp.domain.model.Source
import retrofit2.http.GET
import retrofit2.http.Query
import com.loc.newsapp.util.Constants.API_KEY

interface NewsApi {
    @GET("v2/everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("source") source: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse

    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String
    ): NewsResponse
}