package com.tochange.bonjia.login.model

import com.tochange.bonjia.model.User

/**
 * Created by cristian on 26/06/17.
 */
object FakeUserProvider {

    val email = "cristian@ylly.fr"
    val password = "myPreciousPassword"

    data class Credentials(val email: String, val password: String)

    val sampleCredentials = Credentials(email, password)

    val sampleUser = User(
            id = "ramdomUUID",
            username = email,
            email = email,
            profilePicture = null,
            country = null
    )

}