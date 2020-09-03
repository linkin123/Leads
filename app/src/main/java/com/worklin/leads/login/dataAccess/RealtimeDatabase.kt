package com.worklin.leads.login.dataAccess

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.worklin.leads.R
import com.worklin.leads.base.EventErrorTypeListener
import com.worklin.leads.base.dataAccess.APIS.FirebaseRealtimeDatabaseAPI
import com.worklin.leads.base.pojo.User
import com.worklin.leads.login.events.LoginEvent
import java.util.*

class RealtimeDatabase {
    private val mDatabaseAPI: FirebaseRealtimeDatabaseAPI = FirebaseRealtimeDatabaseAPI.getInstance();

    fun registerUser(user: User) {
        val values: MutableMap<String, Any> =
            HashMap()
        values[User.USERNAME] = user.getUsername() as String
        values[User.EMAIL] = user.getEmail() as String
        values[User.PHOTO_URL] = user.getPhotoUrl() as String
        user.getUid()?.let { mDatabaseAPI.getUserReferenceByUid(it).updateChildren(values) }
    }

    fun checkUserExist(uid: String?, listener: EventErrorTypeListener) {
        uid?.let {
            mDatabaseAPI.getUserReferenceByUid(it).child(User.EMAIL)
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        if (!dataSnapshot.exists()) {
                            listener.onError(LoginEvent.USER_NOT_EXIST, R.string.login_error_user_exist)
                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        listener.onError(LoginEvent.ERROR_SERVER, R.string.login_message_error)
                    }
                })
        }
    }


}