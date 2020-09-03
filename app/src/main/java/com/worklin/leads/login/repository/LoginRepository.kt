package com.worklin.leads.login.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser
import com.worklin.leads.base.dataAccess.access.Authentication
import com.worklin.leads.login.interfaces.StatusAuthCreCallback

class LoginRepository {
    private var mAuthentication = Authentication()

    fun addAuthStateListener() {
        mAuthentication.addAuthStateListener()
    }

    fun removeAuthStateListener() {
        mAuthentication.removeAuthStateListener()
    }

    fun getUidWithUserAndPass(email : String, pass : String) :String{
        var uid  = ""
        mAuthentication.loginWithCredentiales(object : StatusAuthCreCallback{
            override fun onGetUser(user: FirebaseUser?) {
              uid = user?.uid ?: ""
            }

            override fun onError(error: String?) {
                uid = ""
            }
        }, email, pass)
        return uid
    }

}