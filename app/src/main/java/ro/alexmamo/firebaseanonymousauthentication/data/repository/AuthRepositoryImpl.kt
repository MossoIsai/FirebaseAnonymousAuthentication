package ro.alexmamo.firebaseanonymousauthentication.data.repository

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import ro.alexmamo.firebaseanonymousauthentication.domain.model.Response.Failure
import ro.alexmamo.firebaseanonymousauthentication.domain.model.Response.Success
import ro.alexmamo.firebaseanonymousauthentication.domain.repository.AuthRepository
import ro.alexmamo.firebaseanonymousauthentication.domain.repository.SignInResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl  @Inject constructor(
    private val auth: FirebaseAuth
): AuthRepository {
    override val isUserAuthenticatedInFirebase = auth.currentUser != null

    override suspend fun firebaseSignInAnonymously(): SignInResponse {
        return withContext(Dispatchers.IO) {
            try {
                auth.signInAnonymously().await()
                Success(true)
            } catch (e: Exception) {
                Failure(e)
            }
        }
    }
}