package com.posart.githubinfo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GitHubInfoApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}