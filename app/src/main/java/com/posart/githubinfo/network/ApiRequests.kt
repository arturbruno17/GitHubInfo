package com.posart.githubinfo.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    companion object {
        const val BASE_URL = "https://api.github.com/"
    }

    @GET("users/{username}")
    fun getUser(@Path("username") username: String): Call<UserNetwork>

    @GET("users/{username}/repos")
    fun getReposUser(@Path("username") username: String): Call<List<RepoNetwork>>

}
