package com.tilak.apps.moshi.ui.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tilak.apps.moshi.R
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tilak.apps.moshi.data.AirlineModel
import com.tilak.apps.moshi.databinding.ListFragmentBinding
import com.tilak.apps.moshi.utilities.LogHelper

class ListFragment : Fragment() {

    companion object {
        var TAG = "ListFragment"
        fun newInstance() = ListFragment()
    }

    private lateinit var adapterAirlines: AirlinesListAdapter
    private lateinit var binding: ListFragmentBinding
    private lateinit var viewModel: ListViewModel
    private var airlinesList = ArrayList<AirlineModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        adapterAirlines = AirlinesListAdapter(airlinesList)
        val layoutManager = LinearLayoutManager(activity)
        binding.recyclerviewAirlines.layoutManager = layoutManager
        binding.recyclerviewAirlines.adapter = adapterAirlines

        viewModel.listAirlines.observe(viewLifecycleOwner, Observer {
            adapterAirlines.apply {
                addUsers(it)
                notifyDataSetChanged()
            }
            LogHelper.logMessage(TAG, "Airlines list updated....");
        })
    }

}