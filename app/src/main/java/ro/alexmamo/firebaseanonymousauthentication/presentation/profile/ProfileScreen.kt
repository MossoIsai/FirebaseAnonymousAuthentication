package ro.alexmamo.firebaseanonymousauthentication.presentation.profile

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.firebaseanonymousauthentication.presentation.profile.components.ProfileContent
import ro.alexmamo.firebaseanonymousauthentication.presentation.profile.components.ProfileTopBar
import ro.alexmamo.firebaseanonymousauthentication.presentation.profile.components.SignOut

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    navigateToAuthScreen: () -> Unit
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
    SignOut(
        navigateToAuthScreen = { signedOut ->
            if (signedOut) {
                navigateToAuthScreen()
            }
        }
    )
}