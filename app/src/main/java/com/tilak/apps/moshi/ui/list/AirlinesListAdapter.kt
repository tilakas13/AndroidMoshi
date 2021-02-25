package com.tilak.apps.moshi.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

import com.tilak.apps.moshi.data.AirlineModel
import com.tilak.apps.moshi.databinding.ItemListAirlineBinding
import com.tilak.apps.moshi.utilities.LogHelper

class AirlinesListAdapter(private var listAirlines: List<AirlineModel>) :
    RecyclerView.Adapter<AirlinesListAdapter.AirlinesViewHolder>() {

    companion object {
        const val TAG = "AirlinesListAdapter"
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AirlinesViewHolder {
        val binding =
            ItemListAirlineBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AirlinesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AirlinesViewHolder, position: Int) {
        val itemAirlines = listAirlines[position]
        LogHelper.logMessage(TAG, "in onBindViewHolder $itemAirlines.name")
        holder.binding.nameAirlines.text = itemAirlines.defaultName
        holder.binding.phoneNumber.text = itemAirlines.phone
        holder.binding.siteUrl.text = itemAirlines.site


    }

    override fun getItemCount(): Int {
        return listAirlines.size
    }

    fun addUsers(airlinesItems: List<AirlineModel>) {
        LogHelper.logMessage(TAG, "in addUsers")
        this.listAirlines = airlinesItems
    }

    inner class AirlinesViewHolder(var binding: ItemListAirlineBinding) :
        RecyclerView.ViewHolder(binding.root)
}