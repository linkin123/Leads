package com.worklin.leads.login.interfaces

import com.google.firebase.auth.FirebaseUser

interface StatusAuthRegisterCallback {
    fun onGetUser(user: FirebaseUser?)
    fun onError(error: String?)
}