package ro.alexmamo.firebaseanonymousauthentication.domain.repository

import ro.alexmamo.firebaseanonymousauthentication.domain.model.Response

typealias SignInResponse = Response<Boolean>

interface AuthRepository {
    val isUserAuthenticatedInFirebase: Boolean

    suspend fun firebaseSignInAnonymously(): SignInResponse
}