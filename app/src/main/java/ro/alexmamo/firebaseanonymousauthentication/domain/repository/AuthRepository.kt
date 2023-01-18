package ro.alexmamo.firebaseanonymousauthentication.domain.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow
import ro.alexmamo.firebaseanonymousauthentication.domain.model.Response

typealias AuthStateResponse = StateFlow<Boolean>
typealias SignInResponse = Response<Boolean>
typealias SignOutResponse = Response<Boolean>

interface AuthRepository {
    fun getAuthState(viewModelScope: CoroutineScope): AuthStateResponse

    suspend fun firebaseSignInAnonymously(): SignInResponse

    suspend fun firebaseSignOut(): SignOutResponse
}