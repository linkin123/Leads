package com.worklin.leads.base.pojo

import android.net.Uri
import com.google.firebase.database.Exclude

class User {
    companion object{
        val USERNAME = "username"
        val PHOTO_URL = "photoUrl"
        val EMAIL = "email"
        val UID = "uid"
    }

    private var username: String? = null
    private var email: String? = null
    private var photoUrl: String? = null

    @Exclude
    private var uid: String? = null

    @Exclude
    private var uri: Uri? = null

    fun User() {}

    fun getUsername(): String? {
        return username
    }

    fun setUsername(username: String?) {
        this.username = username
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String?) {
        this.email = email
    }

    fun getPhotoUrl(): String? {
        return if (photoUrl != null) photoUrl else uri.toString()
    }

    fun setPhotoUrl(photoUrl: String?) {
        this.photoUrl = photoUrl
    }

    @Exclude
    fun getUid(): String? {
        return uid
    }

    @Exclude
    fun setUid(uid: String?) {
        this.uid = uid
    }

    @Exclude
    fun getUri(): Uri? {
        return uri
    }

    @Exclude
    fun setUri(uri: Uri?) {
        this.uri = uri
    }

    @Exclude
    fun getUsernmeValid(): String? {
        return if (username == null) getEmail() else if (username!!.isEmpty()) getEmail() else username
    }



}