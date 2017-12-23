package com.test.security

import geb.Page

/**
 * Created by zeldris on 23/12/17.
 */
class LoginPage extends Page {

    static url = '/login/auth'

    static at = {
        title == 'Login'
    }

    static content = {
        loginButton { $('#submit', 0) }
        usernameInputField { $('#username', 0) }
        passwordInputField { $('#password', 0) }
    }

    void login(String username, String password) {
        usernameInputField << username
        passwordInputField << password
        loginButton.click()
    }
}
