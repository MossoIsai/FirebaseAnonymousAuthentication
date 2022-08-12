package ro.alexmamo.firebaseanonymousauthentication.domain.repository

import kotlinx.coroutines.flow.Flow
import ro.alexmamo.firebaseanonymousauthentication.domain.model.Response

interface AuthRepository {
    val isUserAuthenticatedInFirebase: Boolean

    fun firebaseSignInAnonymously(): Flow<Response<Boolean>>

    fun signOut(): Flow<Response<Boolean>>
}