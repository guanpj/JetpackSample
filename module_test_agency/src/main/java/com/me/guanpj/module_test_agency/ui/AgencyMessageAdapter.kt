package com.me.guanpj.module_test_agency.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.me.guanpj.module_test_agency.bean.AgencyMessageDataBean
import com.me.guanpj.module_test_agency.databinding.ItemAgencyMessageBinding

class AgencyMessageAdapter(val data: List<AgencyMessageDataBean.Data>) : RecyclerView.Adapter<AgencyMessageAdapter.AgencyMessageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgencyMessageViewHolder {
        val binding = ItemAgencyMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AgencyMessageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AgencyMessageViewHolder, position: Int) {
        holder.binding.bean = data[position]
    }

    override fun getItemCount(): Int = data.size

    inner class AgencyMessageViewHolder(val binding: ItemAgencyMessageBinding) : RecyclerView.ViewHolder(binding.root)
}