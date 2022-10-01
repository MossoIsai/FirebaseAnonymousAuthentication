package ro.alexmamo.firebaseanonymousauthentication.presentation.profile.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import ro.alexmamo.firebaseanonymousauthentication.components.ProgressBar
import ro.alexmamo.firebaseanonymousauthentication.core.Utils.Companion.print
import ro.alexmamo.firebaseanonymousauthentication.domain.model.Response.*
import ro.alexmamo.firebaseanonymousauthentication.presentation.profile.ProfileViewModel

@Composable
fun SignOut(
    viewModel: ProfileViewModel = hiltViewModel(),
    navigateToAuthScreen: (signedOut: Boolean) -> Unit
) {
    when(val signOutResponse = viewModel.signOutResponse) {
        is Loading -> ProgressBar()
        is Success -> signOutResponse.data.let { signedOut ->
            LaunchedEffect(signedOut) {
                navigateToAuthScreen(signedOut)
            }
        }
        is Failure -> LaunchedEffect(Unit) {
            print(signOutResponse.e)
        }
    }
}