package ro.alexmamo.firebaseanonymousauthentication.domain.use_case

import ro.alexmamo.firebaseanonymousauthentication.domain.repository.AuthRepository

class SignIn(
    private val repo: AuthRepository
) {
    suspend operator fun invoke() = repo.firebaseSignInAnonymously()
}