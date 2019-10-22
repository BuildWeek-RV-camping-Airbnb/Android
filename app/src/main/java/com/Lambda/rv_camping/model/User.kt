package com.Lambda.rv_camping.model

data class User (
    val id: Int,
    val first_name: String,
    val last_name: String,
    val email: String,
    val username: String,
    val password: String,
    val owner: Boolean,
    val avatar: String
)