package com.worklin.leads.leadsModule.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.worklin.leads.leadsModule.adapters.LeadListener
import com.worklin.leads.leadsModule.adapters.LeadsAdapter
import com.worklin.leads.leadsModule.viewmodels.LeadsViewModel

import com.worklin.leads.R
import com.worklin.leads.databinding.LeadsFragmentBinding
import com.worklin.leads.db.LocalDatabase

class LeadsFragment : Fragment() {

    companion object {
        fun newInstance() = LeadsFragment()
    }

    private lateinit var viewModel: LeadsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: LeadsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.leads_fragment, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = LocalDatabase.getInstance(application).leadsDao
        viewModel = LeadsViewModel(dataSource)
/*        viewModel = ViewModelProvider(this).get() //sin argumentos de fabrica*/
        viewModel.onStart()
        val leadListener =
            LeadListener { id ->
                viewModel.onLeadCliked(id)
            }
        val adapter = LeadsAdapter(leadListener)
        binding.apply {
            leadsViewModel = viewModel
            lifecycleOwner = this@LeadsFragment
            rvFrLeadsList.adapter = adapter
            rvFrLeadsList.layoutManager = LinearLayoutManager(activity)
        }
        viewModel.leads.observe(viewLifecycleOwner, Observer {
            it?.let {
                Log.d("TAG", it.toString())
                adapter.submitList(it)
            }
        })
        return binding.root
    }


}