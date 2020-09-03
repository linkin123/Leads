package com.worklin.leads.login.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.worklin.leads.login.repository.LoginRepository

class LoginViewModel : ViewModel() {

    companion object{
        val AUTHENTICATION_ACCESS = "usuario authenticado"
        val AUTHENTICATION_NOT_ACCESS = "usuario NO authenticado"
    }

    private val _access = MutableLiveData<Boolean>()
    val access: LiveData<Boolean> get() = _access

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> get() = _message

    private val _progress = MutableLiveData<Boolean>()
    val progress: LiveData<Boolean> get() = _progress

    init {
        _progress.value = false
        _access.value = false
    }

    private var loginRepository = LoginRepository()

    private var uid = ""

    fun loginWithEmailAndPass(user : String , pass : String) {
        _progress.value = true
        uid = loginRepository.getUidWithUserAndPass(user, pass)
        checkResponseUid(uid)
    }

    private fun checkResponseUid(uid: String) {
        if(uid.isNotEmpty()){
            _message.value = AUTHENTICATION_ACCESS
            _access.value = true
        }else{
            _message.value = AUTHENTICATION_NOT_ACCESS
            _access.value = false
        }
        _progress.value = false
    }

}