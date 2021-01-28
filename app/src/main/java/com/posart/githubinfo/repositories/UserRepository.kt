package com.posart.githubinfo.repositories

import android.util.Log
import com.posart.githubinfo.network.GitHubApi
import com.posart.githubinfo.network.RepoNetwork
import com.posart.githubinfo.network.UserNetwork
import kotlinx.coroutines.*
import retrofit2.await
import java.lang.Exception

class UserRepository {
    suspend fun fetchUser(username: String): UserNetwork? {
        return withContext(Dispatchers.IO) {

            val userResponse: UserNetwork? = try {
                GitHubApi().getUser(username).await()
            } catch (e: Exception) {
                null
            }

            Log.i("UserRepository/User", userResponse.toString())
            userResponse
        }
    }

    suspend fun fetchRepos(username: String): List<RepoNetwork>? {
        return withContext(Dispatchers.IO) {

            val repoResponse: List<RepoNetwork>? = try {
                GitHubApi().getReposUser(username).await()
            } catch (e: Exception) {
                null
            }


            Log.i("UserRepository/Repos", repoResponse.toString())
            repoResponse
        }
    }
}