package com.worklin.leads.login.events

import com.google.firebase.auth.FirebaseUser

class LoginEvent {
    companion object{
        val STATUS_AUTH_SUCCESS = 0
        val ERROR_SERVER = 100
        val STATUS_AUTH_ERROR = 101
        val USER_NOT_EXIST = 102
        val SHOW_LOGIN_FULLY = 103
    }

    private var user: FirebaseUser? = null
    private var typeEvent = 0
    private var resMsg = 0

    fun LoginEvent() {}

    fun getUser(): FirebaseUser? {
        return user
    }

    fun setUser(user: FirebaseUser?) {
        this.user = user
    }

    fun getTypeEvent(): Int {
        return typeEvent
    }

    fun setTypeEvent(typeEvent: Int) {
        this.typeEvent = typeEvent
    }

    fun getResMsg(): Int {
        return resMsg
    }

    fun setResMsg(resMsg: Int) {
        this.resMsg = resMsg
    }


}