package com.worklin.leads.registro.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.worklin.leads.R
import com.worklin.leads.base.BaseActivity
import com.worklin.leads.databinding.ActivityRegisterBinding
import com.worklin.leads.registro.view.fragments.DataUserPersonalRegisterFragment

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_register)

        setContentView(binding.root)
        DataUserPersonalRegisterFragment.newInstance()
    }
}