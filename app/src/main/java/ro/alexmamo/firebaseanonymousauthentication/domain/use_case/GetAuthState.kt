package ro.alexmamo.firebaseanonymousauthentication.domain.use_case

import kotlinx.coroutines.CoroutineScope
import ro.alexmamo.firebaseanonymousauthentication.domain.repository.AuthRepository
import ro.alexmamo.firebaseanonymousauthentication.domain.repository.AuthStateResponse

class GetAuthState(
    private val repo: AuthRepository
) {
    operator fun invoke(
        viewModelScope: CoroutineScope
    ): AuthStateResponse = repo.getAuthState(viewModelScope)
}