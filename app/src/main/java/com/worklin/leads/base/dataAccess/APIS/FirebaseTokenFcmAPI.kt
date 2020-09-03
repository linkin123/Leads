package com.worklin.leads.base.dataAccess.APIS

import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.iid.FirebaseInstanceId

class FirebaseTokenFcmAPI {
    private var mFirebaseToken = FirebaseInstanceId.getInstance()

    companion object {
        @Volatile
        private var INSTANCE: FirebaseTokenFcmAPI? = null
        fun getInstance(): FirebaseTokenFcmAPI {
            var instance = INSTANCE
            if (instance == null) {
                instance = FirebaseTokenFcmAPI()
                INSTANCE = instance
            }
            return instance
        }
    }

    fun getToken(context: AppCompatActivity, tokenAccess: TokenAccess) {
        mFirebaseToken.instanceId
            .addOnSuccessListener(context,
                { instanceIdResult -> tokenAccess.onGetToken(instanceIdResult.token) })
            .addOnFailureListener(context,
                { e -> e.message?.let { tokenAccess.onError(it) } })
    }
}