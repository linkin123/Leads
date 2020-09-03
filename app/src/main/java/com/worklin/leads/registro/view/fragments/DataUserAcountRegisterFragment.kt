package com.worklin.leads.registro.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.worklin.leads.R
import com.worklin.leads.databinding.FragmentDataUserAcountRegisterBinding
import com.worklin.leads.registro.model.Chef

class DataUserAcountRegisterFragment : Fragment(){

    private lateinit var binding : FragmentDataUserAcountRegisterBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_data_user_acount_register, container, false)
        viewInteractive()
        return binding.root

    }

    private fun viewInteractive() {
        binding.apply {
            btnNextDataAcountRegister.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(DataUserAcountRegisterFragmentDirections.actionDataAcountToDataCreditCardRegister())
                Chef.email = etEmailUserRegister.text.toString()
                Chef.pass = etPassUserRegister.text.toString()
            }
        }
    }
}