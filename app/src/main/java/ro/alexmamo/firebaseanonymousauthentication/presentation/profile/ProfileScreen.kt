package ro.alexmamo.firebaseanonymousauthentication.presentation.profile

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.firebaseanonymousauthentication.presentation.auth.AuthViewModel
import ro.alexmamo.firebaseanonymousauthentication.presentation.profile.components.ProfileContent
import ro.alexmamo.firebaseanonymousauthentication.presentation.profile.components.ProfileTopBar

@Composable
fun ProfileScreen(
    viewModel: AuthViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            ProfileTopBar(
                signOut = {
                    viewModel.signOut()
                }
            )
        },
        content = { padding ->
            ProfileContent(padding)
        }
    )
}