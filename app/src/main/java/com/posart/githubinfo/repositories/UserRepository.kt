package com.posart.githubinfo.repositories

import android.util.Log
import com.posart.githubinfo.network.*
import kotlinx.coroutines.*
import retrofit2.await
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val gitHubService: GitHubService
) {
    suspend fun fetchUser(username: String): UserNetwork? {
        return withContext(Dispatchers.IO) {

            val userResponse: UserNetwork? = try {
                gitHubService.getUser(username).await()
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
                gitHubService.getReposUser(username).await()
            } catch (e: Exception) {
                null
            }


            Log.i("UserRepository/Repos", repoResponse.toString())
            repoResponse
        }
    }
}