package ro.alexmamo.firebaseanonymousauthentication.domain.use_case

data class UseCases(
    val getAuthState: GetAuthState,
    val signIn: SignIn,
    val signOut: SignOut
)