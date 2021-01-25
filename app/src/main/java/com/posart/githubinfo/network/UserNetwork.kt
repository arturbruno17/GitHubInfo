package com.posart.githubinfo.network

data class UserNetwork(
    val avatar_url: String,
    val bio: String,
    val followers: Int,
    val following: Int,
    val location: String,
    val login: String
)