package ro.alexmamo.firebaseanonymousauthentication.presentation.auth.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.firebaseanonymousauthentication.components.ProgressBar
import ro.alexmamo.firebaseanonymousauthentication.core.Utils.Companion.print
import ro.alexmamo.firebaseanonymousauthentication.domain.model.Response.*
import ro.alexmamo.firebaseanonymousauthentication.presentation.auth.AuthViewModel

@Composable
fun SignOut(
    viewModel: AuthViewModel = hiltViewModel()
) {
    when(val signOutResponse = viewModel.signOutResponse) {
        is Loading -> ProgressBar()
        is Success -> Unit
        is Failure -> LaunchedEffect(Unit) {
            print(signOutResponse.e)
        }
    }
}