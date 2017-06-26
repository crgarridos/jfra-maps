package com.tochange.bonjia.login

/**
 * Created by cristian on 26/06/17
 */
open class UserException(message: String) : Exception(message)

class UserAlreadyExistsException(val parent: Throwable? = null)
    : UserException(parent?.message ?: "The user exist already")

class UserInvalidCredentialsException(val parent: Throwable? = null)
    : UserException(parent?.message ?: "The credentials provided does not match with any user")

class UserUnknownException(val parent: Throwable? = null)
    : UserException(parent?.message ?: "An unknown error occurred with the user")

//class UserAlreadyExistsException : Exception("The user exist already")