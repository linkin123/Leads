package com.worklin.leads.base.dataAccess.APIS

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.worklin.leads.base.pojo.User

object FirebaseAuthenticationAPI {

    private var mFirebaseAuth = FirebaseAuth.getInstance()


    fun getFirebaseAuth(): FirebaseAuth{
        return this.mFirebaseAuth
    }

    fun getAuthUser(): User? {
        val user = User()
        mFirebaseAuth.currentUser?.let {
            user.apply{
                setUid(mFirebaseAuth.currentUser?.uid)
                setUsername(mFirebaseAuth.currentUser?.displayName)
                setEmail(mFirebaseAuth.currentUser?.email)
                setUri(mFirebaseAuth.currentUser?.photoUrl)
            }
        }
        return user
    }

    fun getCurrentUser(): FirebaseUser? {
        return mFirebaseAuth.currentUser
    }


}