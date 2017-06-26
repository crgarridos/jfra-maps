package com.tochange.bonjia.login

/**
 * Created by cristian on 26/06/17.
 */
class UserAlreadyExistsException : IllegalStateException("The user exist already")
class UserInvalidCredentialsException : IllegalStateException("The credentials provided does not match with any user")
class UserUnknownException(parent: Throwable? = null) : IllegalStateException("An unknown error occurred with the user")

//class UserAlreadyExistsException : IllegalStateException("The user exist already")