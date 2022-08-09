package ro.alexmamo.firebaseanonymousauthentication.core

import android.util.Log
import ro.alexmamo.firebaseanonymousauthentication.core.Constants.TAG

class Utils {
    companion object {
        fun print(e: Exception) {
            Log.e(TAG, e.message ?: e.toString())
        }
    }
}