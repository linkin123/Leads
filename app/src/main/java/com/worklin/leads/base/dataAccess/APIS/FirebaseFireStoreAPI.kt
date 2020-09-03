package com.worklin.leads.base.dataAccess.APIS

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseFireStoreAPI {

    private val COLL__USUARIOS = "usuarios"

    private val mFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    companion object{
        @Volatile
        private var INSTANCE: FirebaseFireStoreAPI? = null
        fun getInstance(): FirebaseFireStoreAPI {
            synchronized(this){
                var instance =
                    INSTANCE
                if(instance == null){
                    instance =
                        FirebaseFireStoreAPI()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    fun getFirebaseFireStore() : FirebaseFirestore{
        return this.mFirestore
    }

    fun getUserReference() : CollectionReference{
        return getFirebaseFireStore().collection(COLL__USUARIOS)
    }


    fun getReferenceBiUID(uid : String ): DocumentReference {
        return getFirebaseFireStore().collection(COLL__USUARIOS).document(uid)
    }

}