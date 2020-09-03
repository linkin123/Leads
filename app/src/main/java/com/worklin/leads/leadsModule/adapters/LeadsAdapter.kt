package com.worklin.leads.leadsModule.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.worklin.leads.databinding.ListItemLeadsBinding
import com.worklin.leads.leadsModule.models.Lead


class LeadsAdapter(val clickListener: LeadListener) :
    ListAdapter<Lead, LeadsAdapter.ViewHolder>(
        LeadDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }

    class ViewHolder private constructor(val binding: ListItemLeadsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Lead, clickListener: LeadListener) {
            binding.lead = item
            binding.clicklistener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemLeadsBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(
                    binding
                )
            }
        }
    }
}

class LeadDiffCallback : DiffUtil.ItemCallback<Lead>() {
    override fun areItemsTheSame(oldItem: Lead, newItem: Lead): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Lead, newItem: Lead): Boolean {
        return oldItem == newItem
    }

}

class LeadListener(val clickListener: (id: Int) -> Unit) {
    fun onclick(id: Int) = clickListener(id)
}