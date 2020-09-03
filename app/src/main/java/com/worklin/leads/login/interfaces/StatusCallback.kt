package com.worklin.leads.login.interfaces

import com.google.firebase.auth.FirebaseUser

interface StatusCallback {
    fun onGetUser(user: FirebaseUser?)
    fun onLaunchUILogin()
}