package com.posart.githubinfo.viewmodels

import androidx.lifecycle.*
import com.posart.githubinfo.network.RepoNetwork
import com.posart.githubinfo.network.UserNetwork
import com.posart.githubinfo.repositories.UserRepository
import kotlinx.coroutines.launch

class DetailsViewModel() : ViewModel() {

    val user = MutableLiveData<UserNetwork>()
    val reposUser = MutableLiveData<List<RepoNetwork>>()

    fun getUserAndRepos(username: String) {
        viewModelScope.launch {
            val userApi = UserRepository().fetchUser(username)
            val reposUserApi = UserRepository().fetchRepos(username)

            user.value = userApi
            reposUser.value = reposUserApi
        }
    }

}