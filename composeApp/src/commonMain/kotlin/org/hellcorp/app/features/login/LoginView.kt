package org.hellcorp.app.features.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.hellcorp.app.features.login.models.LoginEvent
import org.hellcorp.app.features.login.models.LoginViewState
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun LoginView(
    viewState: LoginViewState,
    eventHandler: (LoginEvent) -> Unit
) {
    Column {
        Text(viewState.emailValue)
        Text(viewState.passwordValue)
    }
}

@Composable
@Preview
internal fun loginViewPreview() {
    LoginView(
        viewState = LoginViewState(
            emailValue = "Hiper Jack",
            passwordValue = "ashd212312"
        ),
        eventHandler = {}
    )
}