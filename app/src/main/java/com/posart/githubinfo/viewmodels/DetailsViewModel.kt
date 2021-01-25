package com.posart.githubinfo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.posart.githubinfo.repositories.UserRepository

class DetailsViewModel(username: String) : ViewModel() {

    val user = UserRepository().getUser(username)

    class Factory(private val username: String) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return DetailsViewModel(username) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }

    }

}