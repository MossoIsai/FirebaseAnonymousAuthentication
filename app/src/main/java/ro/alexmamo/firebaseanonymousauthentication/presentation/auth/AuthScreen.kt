package ro.alexmamo.firebaseanonymousauthentication.presentation.auth

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.firebaseanonymousauthentication.presentation.auth.components.AuthContent
import ro.alexmamo.firebaseanonymousauthentication.presentation.auth.components.AuthTopBar
import ro.alexmamo.firebaseanonymousauthentication.presentation.auth.components.SignIn

@Composable
fun AuthScreen(
    viewModel: AuthViewModel = hiltViewModel(),
    navigateToProfileScreen: () -> Unit
) {
    Scaffold(
        topBar = {
            AuthTopBar()
        },
        content = { padding ->
            AuthContent(
                padding = padding,
                signIn = {
                    viewModel.signIn()
                }
            )
        }
    )
    SignIn(
        navigateToProfileScreen = { signedIn ->
            if (signedIn) {
                navigateToProfileScreen()
            }
        }
    )
}