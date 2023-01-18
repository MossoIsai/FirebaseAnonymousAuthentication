package ro.alexmamo.firebaseanonymousauthentication.domain.use_case

import ro.alexmamo.firebaseanonymousauthentication.domain.repository.AuthRepository

class SignOut(
    private val repo: AuthRepository
) {
    suspend operator fun invoke() = repo.firebaseSignOut()
}