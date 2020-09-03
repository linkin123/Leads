package com.worklin.leads.registro.dataAccess

import com.worklin.leads.leadsModule.utils.*
import com.worklin.leads.base.dataAccess.APIS.FirebaseFireStoreAPI
import com.worklin.leads.base.pojo.User
import java.util.*

class FireStore {

    var mFireStoreAPI: FirebaseFireStoreAPI = FirebaseFireStoreAPI.getInstance()

    fun addUser(user: User, fireStoreCallback: FireStoreCallback) {
        val values: MutableMap<String, Any> = HashMap()
        values[USER_NAME] = user.getUsername() as String
        values[USER_EMAIL] = user.getUsername() as String
        values[USER_PHOTO_URL] = user.getUsername() as String

        mFireStoreAPI.getUserReference().add(values)
            .addOnSuccessListener {
                fireStoreCallback.onSucess()
            }.addOnFailureListener { e ->
                fireStoreCallback.onError(e.message)
            }
    }
}