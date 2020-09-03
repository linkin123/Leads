package com.worklin.leads.registro.repository

import com.google.firebase.auth.FirebaseUser
import com.worklin.leads.base.dataAccess.access.Authentication
import com.worklin.leads.login.interfaces.StatusAuthRegisterCallback

class CreateAcountRepository {
    private var mAuthentication = Authentication()

    fun getUidWithUserAndPass(email: String, pass : String): String{
        var uid = ""
        mAuthentication.register(object : StatusAuthRegisterCallback{
            override fun onGetUser(user: FirebaseUser?) {
                uid = user?.uid ?: ""
            }

            override fun onError(error: String?) {
                uid = ""
            }
        }, email, pass)
        return  uid
    }
}