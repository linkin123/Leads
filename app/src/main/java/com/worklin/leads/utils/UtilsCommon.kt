package com.worklin.leads.utils

/*
     * Codificar un correo electronico
     * */
fun getEmailEncoded(email: String): String {
    val preKey = email.replace("_", "__")
    return preKey.replace(".", "_")
}
