package com.worklin.leads.base.dataAccess.APIS

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FirebaseRealtimeDatabaseAPI {
    val PATH_USERS = "users"
    val PATH_LEADS = "leads"

    private var mDataReference = FirebaseDatabase.getInstance().reference


    companion object {
        @Volatile
        private var INSTANCE: FirebaseRealtimeDatabaseAPI? = null
        fun getInstance(): FirebaseRealtimeDatabaseAPI {
            synchronized(this) {
                var instance =
                    INSTANCE
                if (instance == null) {
                    instance =
                        FirebaseRealtimeDatabaseAPI()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    /*
    * references
    *
    * */

    /*get root reference*/
    fun getRootReference() : DatabaseReference{
        return mDataReference.root
    }

    /*get user uid*/
    fun getUserReferenceByUid(uid: String) : DatabaseReference {
        return getRootReference().child(PATH_USERS).child(uid)
    }

    /*get leads*/
    fun getLeadsReference(uid : String) : DatabaseReference{
        return getRootReference().child(uid).child(PATH_LEADS)
    }

}