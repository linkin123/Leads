package com.worklin.leads.base.dataAccess.APIS

import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.worklin.leads.utils.getEmailEncoded

class FirebaseStorageAPI {

    private lateinit var mFirebaseStorage: FirebaseStorage

    companion object {
        @Volatile
        private var INSTANCE: FirebaseStorageAPI? = null
        fun getInstance(): FirebaseStorageAPI {
            synchronized(this) {
                var instance =
                    INSTANCE
                if (instance == null) {
                    instance =
                        FirebaseStorageAPI()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    fun FirebaseStorageAPI(){
        this.mFirebaseStorage = FirebaseStorage.getInstance()
    }

    fun getmFirebaseStorage(): FirebaseStorage{
        return mFirebaseStorage
    }

    fun getPhotosReferenceByEmail(email:String): StorageReference{
        return mFirebaseStorage.getReference().child(getEmailEncoded(email))
    }

}