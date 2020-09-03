package com.worklin.leads.registro.dataAccess

import com.worklin.leads.base.dataAccess.APIS.FirebaseAuthenticationAPI
import com.worklin.leads.base.pojo.User

class Authentication() {

    private var mAuthenticationAPI = FirebaseAuthenticationAPI

    fun getCurrentUser(): User? {
        return mAuthenticationAPI.getAuthUser()
    }



}