package com.posart.githubinfo.viewmodels

import androidx.lifecycle.*
import com.posart.githubinfo.network.RepoNetwork
import com.posart.githubinfo.network.UserNetwork
import com.posart.githubinfo.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    val user = MutableLiveData<UserNetwork>()
    val reposUser = MutableLiveData<List<RepoNetwork>>()

    fun getUserAndRepos(username: String) {
        viewModelScope.launch {
            val userApi = userRepository.fetchUser(username)
            val reposUserApi = userRepository.fetchRepos(username)

            user.value = userApi
            reposUser.value = reposUserApi
        }
    }

}