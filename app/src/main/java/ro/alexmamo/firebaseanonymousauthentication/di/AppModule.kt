package ro.alexmamo.firebaseanonymousauthentication.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ro.alexmamo.firebaseanonymousauthentication.data.repository.AuthRepositoryImpl
import ro.alexmamo.firebaseanonymousauthentication.domain.repository.AuthRepository
import ro.alexmamo.firebaseanonymousauthentication.domain.use_case.GetAuthState
import ro.alexmamo.firebaseanonymousauthentication.domain.use_case.SignIn
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
    fun provideUseCases(
        repo: AuthRepository
    ) = UseCases(
        getAuthState = GetAuthState(repo),
        signIn = SignIn(repo),
        signOut = SignOut(repo)
    )
}