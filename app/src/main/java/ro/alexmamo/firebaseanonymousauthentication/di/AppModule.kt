package ro.alexmamo.firebaseanonymousauthentication.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ro.alexmamo.firebaseanonymousauthentication.data.repository.AuthRepositoryImpl
import ro.alexmamo.firebaseanonymousauthentication.data.repository.ProfileRepositoryImpl
import ro.alexmamo.firebaseanonymousauthentication.domain.repository.AuthRepository
import ro.alexmamo.firebaseanonymousauthentication.domain.repository.ProfileRepository
import ro.alexmamo.firebaseanonymousauthentication.domain.use_case.IsUserAuthenticated
import ro.alexmamo.firebaseanonymousauthentication.domain.use_case.SignInAnonymously
import ro.alexmamo.firebaseanonymousauthentication.domain.use_case.SignOut
import ro.alexmamo.firebaseanonymousauthentication.domain.use_case.UseCases

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideFirebaseAuth() = Firebase.auth

    @Provides
    fun provideAuthRepository(
        auth: FirebaseAuth
    ): AuthRepository = AuthRepositoryImpl(auth)

    @Provides
    fun provideProfileRepository(
        auth: FirebaseAuth
    ): ProfileRepository = ProfileRepositoryImpl(auth)

    @Provides
    fun provideUseCases(
        authRepo: AuthRepository,
        profileRepo: ProfileRepository
    ) = UseCases(
        isUserAuthenticated = IsUserAuthenticated(authRepo),
        signInAnonymously = SignInAnonymously(authRepo),
        signOut = SignOut(profileRepo)
    )
}