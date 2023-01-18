package ro.alexmamo.firebaseanonymousauthentication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ro.alexmamo.firebaseanonymousauthentication.navigation.NavGraph
import ro.alexmamo.firebaseanonymousauthentication.navigation.Screen.AuthScreen
import ro.alexmamo.firebaseanonymousauthentication.navigation.Screen.ProfileScreen
import ro.alexmamo.firebaseanonymousauthentication.presentation.auth.AuthViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            NavGraph(
                navController = navController
            )
            AuthState()
        }
    }

    @Composable
    private fun AuthState() {
        val isUserSignedOut = viewModel.getAuthState().collectAsState().value
        if (isUserSignedOut) {
            NavigateToAuthScreen()
        } else {
            NavigateToProfileScreen()
        }
    }

    @Composable
    private fun NavigateToAuthScreen() = navController.navigate(AuthScreen.route) {
        popUpTo(navController.graph.id) {
            inclusive = true
        }
    }

    @Composable
    private fun NavigateToProfileScreen() = navController.navigate(ProfileScreen.route) {
        popUpTo(navController.graph.id) {
            inclusive = true
        }
    }
}