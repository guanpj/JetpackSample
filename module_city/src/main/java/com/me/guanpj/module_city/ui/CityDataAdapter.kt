package com.me.guanpj.module_city.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.me.guanpj.module_city.bean.CityDataBean
import com.me.guanpj.module_city.databinding.ItemCityDataBinding

class CityDataAdapter(
    var data: List<CityDataBean.CityBean>,
    val callback: (Int, CityDataBean.CityBean) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemCityDataBinding.inflate(
            LayoutInflater.from(
                parent.context
            )
        )
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val dataHolder = holder as DataViewHolder
        dataHolder.binding.data = data[position]
        dataHolder.binding.tvFirstLetter.visibility = View.VISIBLE
        if (position >= 1) {
            if (data[position].firstLetter != data[position - 1].firstLetter) {
                dataHolder.binding.tvFirstLetter.visibility = View.VISIBLE
            } else {
                dataHolder.binding.tvFirstLetter.visibility = View.GONE
            }
        }
        dataHolder.binding.llParent.setOnClickListener {
            callback(position, data[position])
        }
    }

    override fun getItemCount(): Int = data.size

    internal class DataViewHolder(val binding: ItemCityDataBinding) :
        RecyclerView.ViewHolder(binding.root)

}