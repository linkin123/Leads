package com.worklin.leads.base.dataAccess.APIS

interface TokenAccess {
    fun onGetToken(token : String)
    fun onError(error: String)
}