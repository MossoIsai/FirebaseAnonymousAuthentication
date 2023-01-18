package ro.alexmamo.firebaseanonymousauthentication.presentation.auth.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.firebaseanonymousauthentication.components.ProgressBar
import ro.alexmamo.firebaseanonymousauthentication.core.Utils.Companion.print
import ro.alexmamo.firebaseanonymousauthentication.domain.model.Response.*
import ro.alexmamo.firebaseanonymousauthentication.presentation.auth.AuthViewModel

@Composable
fun SignIn(
    viewModel: AuthViewModel = hiltViewModel()
) {
    when(val signInResponse = viewModel.signInResponse) {
        is Loading -> ProgressBar()
        is Success -> Unit
        is Failure -> LaunchedEffect(Unit) {
            print(signInResponse.e)
        }
    }
}