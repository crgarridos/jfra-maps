package com.tochange.bonjia.model

/**
 * Created by cristian on 30/05/17
 */
data class User(val id: String,
                val username: String,
                val email: String,
                val profilePicture: String?,
                val country: String?,
                val photos : List<String> = listOf())