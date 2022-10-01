package ro.alexmamo.firebaseanonymousauthentication.domain.repository

import ro.alexmamo.firebaseanonymousauthentication.domain.model.Response

typealias SignOutResponse = Response<Boolean>

interface ProfileRepository {
    suspend fun signOut(): SignOutResponse
}