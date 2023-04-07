package com.example.realm.presentation.screen.auth

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.realm.utils.Constants.CLIENT_ID
import com.stevdzasan.onetap.OneTapSignInState
import com.stevdzasan.onetap.OneTapSignInWithGoogle

@Composable
fun AuthenticationScreen(
    loadingState: Boolean,
    oneTapSignInState: OneTapSignInState,
    onButtonClicked: () -> Unit,
) {
    Scaffold {
        AuthenticationContent(
            loadingState = loadingState,
            onButtonClicked = onButtonClicked,
        )
    }

    OneTapSignInWithGoogle(
        state = oneTapSignInState,
        clientId = CLIENT_ID,
        onTokenIdReceived = { tokenId ->
            Log.d("Auth", tokenId)
        },
        onDialogDismissed = { message ->
            Log.d("Auth", message)
        },
    )
}