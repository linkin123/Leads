package com.worklin.leads.registro.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.worklin.leads.MainActivity
import com.worklin.leads.R
import com.worklin.leads.databinding.FragmentDataUserCreditCardRegisterBinding
import com.worklin.leads.login.view.LoginActivity
import com.worklin.leads.registro.model.Chef
import com.worklin.leads.registro.viewmodels.DataUserRegisterViewModel

class DataUserCreditCardRegisterFragment : Fragment() {

    private lateinit var binding: FragmentDataUserCreditCardRegisterBinding
    private lateinit var dataUserRegisterViewModel: DataUserRegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_data_user_credit_card_register,
            container,
            false
        )

        dataUserRegisterViewModel = ViewModelProvider(this).get()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onclicks()
        observers()
    }

    private fun observers() {
        activity?.let {
            dataUserRegisterViewModel.auth.observe(it, Observer { access ->
                if (access) {
                    openLoginActivity()
                }
            })

            dataUserRegisterViewModel.message.observe(it, Observer { message ->
                Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
            })
            dataUserRegisterViewModel.progress.observe(it, Observer { progress ->
                binding.progressBarRegister.visibility = if (progress) View.VISIBLE else View.GONE
            })
        }
    }

    private fun openLoginActivity() {
        val intent = Intent(activity, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        activity?.finish()
    }

    private fun onclicks() {
        binding.apply {
            btnFinishRegister.setOnClickListener {
                dataUserRegisterViewModel.registerWithEmailAndPass(Chef.email, Chef.pass)
            }
        }

    }

}