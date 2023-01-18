package ro.alexmamo.firebaseanonymousauthentication.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.tasks.await
import ro.alexmamo.firebaseanonymousauthentication.domain.model.Response.Failure
import ro.alexmamo.firebaseanonymousauthentication.domain.model.Response.Success
import ro.alexmamo.firebaseanonymousauthentication.domain.repository.AuthRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl  @Inject constructor(
    private val auth: FirebaseAuth
): AuthRepository {
    override fun getAuthState(viewModelScope: CoroutineScope) = callbackFlow {
        val authStateListener = AuthStateListener { auth ->
            trySend(auth.currentUser == null)
        }
        auth.addAuthStateListener(authStateListener)
        awaitClose {
            auth.removeAuthStateListener(authStateListener)
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), auth.currentUser == null)

    override suspend fun firebaseSignInAnonymously() = try {
        auth.signInAnonymously().await()
        Success(true)
    } catch (e: Exception) {
        Failure(e)
    }

    override suspend fun firebaseSignOut() = try {
        auth.currentUser?.delete()?.await()
        Success(true)
    } catch (e: Exception) {
        Failure(e)
    }
}