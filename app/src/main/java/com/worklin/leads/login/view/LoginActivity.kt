package com.worklin.leads.login.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.worklin.leads.MainActivity
import com.worklin.leads.databinding.ActivityLoginBinding
import com.worklin.leads.login.viewmodels.LoginViewModel
import com.worklin.leads.registro.view.activities.RegisterActivity


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginViewModel = LoginViewModel()
        onclicks(binding)
        observers()
    }

    private fun onclicks(binding: ActivityLoginBinding) {
        binding.apply {
            btnStartLogin.setOnClickListener {
                loginViewModel.loginWithEmailAndPass(
                    getTxt(binding.etUserLogin),
                    getTxt(binding.etPassLogin)
                )
            }
            btnStartRegister.setOnClickListener {
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java) )
            }
        }
    }

    private fun getTxt(et: EditText): String {
        return et.text.toString()
    }

    private fun observers() {
        loginViewModel.access.observe(this, Observer { access ->
            if (access) {
                openMainActivity()
            }
        })

        loginViewModel.message.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        })

        loginViewModel.progress.observe(this, Observer { progress ->
            binding.progressBar.visibility = if (progress) View.VISIBLE else View.GONE
        })
    }

    fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }

}