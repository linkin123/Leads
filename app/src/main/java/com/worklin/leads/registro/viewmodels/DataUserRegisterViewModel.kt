package com.worklin.leads.registro.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.worklin.leads.registro.repository.CreateAcountRepository

open class DataUserRegisterViewModel : ViewModel() {

    companion object {
        val AUTHENTICATION_ACCESS = "usuario registrado exitosamente"
        val AUTHENTICATION_NOT_ACCESS = "Ocurrio un error"
    }


    private val _auth = MutableLiveData<Boolean>()
    val auth: LiveData<Boolean> get() = _auth

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> get() = _message

    private val _progress = MutableLiveData<Boolean>()
    val progress: LiveData<Boolean> get() = _progress

    private var uid = ""


    init {
        _progress.value = false
        _auth.value = false
    }

    private var createAcountRepository = CreateAcountRepository()

    fun registerWithEmailAndPass(email: String, pass: String) {
        uid = createAcountRepository.getUidWithUserAndPass(email, pass)
        if (uid.isNotEmpty()) {
            _message.value = AUTHENTICATION_ACCESS
            _auth.value = true
        } else {
            _message.value = AUTHENTICATION_NOT_ACCESS
            _auth.value = false
        }
        _progress.value = false
    }
}