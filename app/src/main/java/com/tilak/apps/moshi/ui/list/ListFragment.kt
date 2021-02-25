package com.tilak.apps.moshi.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.tilak.apps.moshi.data.model.AirlineModel
import com.tilak.apps.moshi.databinding.ListFragmentBinding
import com.tilak.apps.moshi.utilities.AppConstants
import com.tilak.apps.moshi.utilities.LogHelper

class ListFragment : Fragment() {

    private val navigationArgs: ListFragmentArgs by navArgs()


    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var adapterAirlines: AirlinesListAdapter
    private lateinit var binding: ListFragmentBinding
    private lateinit var viewModel: ListViewModel
    private var airlinesList = ArrayList<AirlineModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val selectedSourceType = navigationArgs.SourceType
        LogHelper.logMessage(
            AppConstants.TAG_LOGS,
            "Selected source type ->$selectedSourceType"
        )

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.fetchAirlinesList(selectedSourceType)
        adapterAirlines = AirlinesListAdapter(airlinesList)
        val layoutManager = LinearLayoutManager(activity)
        binding.recyclerviewAirlines.layoutManager = layoutManager
        binding.recyclerviewAirlines.adapter = adapterAirlines

        viewModel.listAirlines.observe(viewLifecycleOwner, Observer {
            adapterAirlines.apply {
                addUsers(it)
                notifyDataSetChanged()
            }
            LogHelper.logMessage(AppConstants.TAG_LOGS, "Airlines list updated....");
        })
    }

}