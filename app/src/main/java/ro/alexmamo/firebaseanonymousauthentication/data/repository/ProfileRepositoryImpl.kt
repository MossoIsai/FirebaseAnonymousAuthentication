package ro.alexmamo.firebaseanonymousauthentication.data.repository

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import ro.alexmamo.firebaseanonymousauthentication.domain.model.Response.Failure
import ro.alexmamo.firebaseanonymousauthentication.domain.model.Response.Success
import ro.alexmamo.firebaseanonymousauthentication.domain.repository.ProfileRepository
import ro.alexmamo.firebaseanonymousauthentication.domain.repository.SignOutResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileRepositoryImpl  @Inject constructor(
    private val auth: FirebaseAuth
): ProfileRepository {
    override suspend fun signOut(): SignOutResponse {
        return try {
            auth.currentUser?.delete()?.await()
            Success(true)
        } catch (e: Exception) {
            Failure(e)
        }
    }
}