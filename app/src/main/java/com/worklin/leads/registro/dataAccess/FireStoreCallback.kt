package com.worklin.leads.registro.dataAccess

interface FireStoreCallback {
    fun onSucess()
    fun onError(message: String?)
}