package com.worklin.leads.base.dataAccess.access

import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import com.worklin.leads.base.dataAccess.APIS.FirebaseAuthenticationAPI
import com.worklin.leads.base.pojo.User
import com.worklin.leads.login.interfaces.StatusAuthCreCallback
import com.worklin.leads.login.interfaces.StatusAuthRegisterCallback
import com.worklin.leads.login.interfaces.StatusCallback


class Authentication {

    private var mAuthenticationAPI : FirebaseAuthenticationAPI
    private lateinit var mAuthStateListener: AuthStateListener
    private val mResendToken: ForceResendingToken? = null

    init {
        mAuthenticationAPI = FirebaseAuthenticationAPI
    }

    fun addAuthStateListener() {
        mAuthenticationAPI.getFirebaseAuth().addAuthStateListener(mAuthStateListener)
    }

    fun removeAuthStateListener() {
        mAuthenticationAPI.getFirebaseAuth().removeAuthStateListener(mAuthStateListener)
    }

    fun getStatusAuth(callback: StatusCallback) {
        mAuthStateListener = AuthStateListener { firebaseAuth ->
            val user = firebaseAuth.currentUser
            if (user != null) {
                callback.onGetUser(user)
            } else {
                callback.onLaunchUILogin()
            }
        }
    }

    fun loginWithCredentiales(statusAuthCreCallback: StatusAuthCreCallback, email : String, pass : String){
        mAuthenticationAPI.getFirebaseAuth().signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = mAuthenticationAPI.getFirebaseAuth().currentUser
                    if (user != null) {
                        statusAuthCreCallback.onGetUser(user)
                    } else {
                        statusAuthCreCallback.onError("Error al ingresar FS")
                    }
                }
            }.addOnFailureListener { e -> statusAuthCreCallback.onError(e.message) }
    }

    fun register(callback: StatusAuthRegisterCallback, email: String, password: String) {
        mAuthenticationAPI.getFirebaseAuth().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = mAuthenticationAPI.getCurrentUser()
                    callback.onGetUser(user)
                }
            }.addOnFailureListener { e -> callback.onError(e.message) }
    }


    fun getCurrentUser(): User? {
        return mAuthenticationAPI.getAuthUser()
    }



}