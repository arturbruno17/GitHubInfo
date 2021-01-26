package com.posart.githubinfo.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.posart.githubinfo.network.GitHubApi
import com.posart.githubinfo.network.RepoNetwork
import com.posart.githubinfo.network.UserNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    fun getUser(username: String): LiveData<UserNetwork> {
        val userResponse = MutableLiveData<UserNetwork>()

        GitHubApi().getUser(username).enqueue(object : Callback<UserNetwork> {
            override fun onFailure(call: Call<UserNetwork>, t: Throwable) {
                userResponse.value = null
            }

            override fun onResponse(call: Call<UserNetwork>, response: Response<UserNetwork>) {
                if (response.isSuccessful) {
                    userResponse.value = response.body()
                } else {
                    userResponse.value = null
                }
            }

        })

        return userResponse
    }

    fun getUserRepos(username: String): LiveData<List<RepoNetwork>> {
        val reposResponse = MutableLiveData<List<RepoNetwork>>()

        GitHubApi().getReposUser(username).enqueue(object : Callback<List<RepoNetwork>> {
            override fun onFailure(call: Call<List<RepoNetwork>>, t: Throwable) {
                reposResponse.value = null
            }

            override fun onResponse(
                call: Call<List<RepoNetwork>>,
                response: Response<List<RepoNetwork>>
            ) {
                if (response.isSuccessful) {
                    reposResponse.value = response.body()
                } else {
                    reposResponse.value = null
                }
            }
        })

        return reposResponse
    }
}