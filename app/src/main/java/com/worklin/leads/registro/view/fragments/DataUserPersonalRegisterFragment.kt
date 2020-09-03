package com.worklin.leads.registro.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.worklin.leads.R
import com.worklin.leads.databinding.FragmentDataUserPersonalRegisterBinding
import com.worklin.leads.registro.model.Chef

class DataUserPersonalRegisterFragment : Fragment(){

    private lateinit var binding : FragmentDataUserPersonalRegisterBinding

    companion object{
        fun newInstance(): DataUserAcountRegisterFragment? {
            val fragment = DataUserAcountRegisterFragment()
            val args = Bundle()
            fragment.setArguments(args)
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_data_user_personal_register, container, false)
        viewInteractive()
        return binding.root
    }

    private fun viewInteractive() {
        binding.apply {
            btnNextDataUserPersonalRegister.setOnClickListener {
                saveDataInSingletonObject()
                Navigation.findNavController(it)
                    .navigate(DataUserPersonalRegisterFragmentDirections.actionDataPersonalToDataAcountRegister())
            }
        }
    }

    private fun saveDataInSingletonObject() {
        binding.apply {
            Chef.name = etNameUserRegister.text.toString()
            Chef.lastName = etLastParentUserRegister.text.toString()
            Chef.secondName = etSecondParentUserRegister.text.toString()
        }
    }

    fun editextIsNotEmpty(editText: EditText) : Boolean{
        return if(editText.text.toString().isNotEmpty()) true else false

    }
}