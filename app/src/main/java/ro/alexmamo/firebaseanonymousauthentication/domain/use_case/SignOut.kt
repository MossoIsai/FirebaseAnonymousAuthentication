package ro.alexmamo.firebaseanonymousauthentication.domain.use_case

import ro.alexmamo.firebaseanonymousauthentication.domain.repository.ProfileRepository

class SignOut(
    private val repository: ProfileRepository
) {
    suspend operator fun invoke() = repository.signOut()
}