package com.posart.githubinfo.viewmodels

import androidx.lifecycle.*
import com.posart.githubinfo.network.RepoNetwork
import com.posart.githubinfo.network.UserNetwork
import com.posart.githubinfo.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class ProgressStatus {
    LOADING, CONCLUDED, ERROR
}

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    val user = MutableLiveData<UserNetwork>()
    val reposUser = MutableLiveData<List<RepoNetwork>>()

    private val _status = MutableLiveData<ProgressStatus>()
    val status: LiveData<ProgressStatus>
        get() = _status

    fun getUserAndRepos(username: String) {
        viewModelScope.launch {
            _status.value = ProgressStatus.LOADING

            val userApi = userRepository.fetchUser(username)
            val reposUserApi = userRepository.fetchRepos(username)

            if (userApi != null) {
                _status.value = ProgressStatus.CONCLUDED
            } else {
                _status.value = ProgressStatus.ERROR
            }

            user.value = userApi
            reposUser.value = reposUserApi
        }
    }

}