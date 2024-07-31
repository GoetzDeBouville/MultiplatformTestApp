package org.hellcorp.app.features.login

import org.hellcorp.app.base.BaseViewModel
import org.hellcorp.app.features.login.models.LoginAction
import org.hellcorp.app.features.login.models.LoginEvent
import org.hellcorp.app.features.login.models.LoginViewState

class LoginViewModel : BaseViewModel<LoginViewState, LoginAction, LoginEvent>(initialState = LoginViewState()){
    override fun obtainEvent(viewEvent: LoginEvent) {

    }
}