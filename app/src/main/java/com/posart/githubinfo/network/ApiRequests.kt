package com.posart.githubinfo.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    @GET("users/{username}")
    fun getUser(@Path("username") username: String): Call<UserNetwork>

    @GET("users/{username}/repos")
    fun getReposUser(@Path("username") username: String): Call<List<ReposNetwork>>

    companion object {
        operator fun invoke() : GitHubApi {
            return Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GitHubApi::class.java)
        }
    }
}

