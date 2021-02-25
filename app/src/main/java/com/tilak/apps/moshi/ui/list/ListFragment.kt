package com.tilak.apps.moshi.ui.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tilak.apps.moshi.R
import androidx.lifecycle.Observer
import com.tilak.apps.moshi.databinding.ListFragmentBinding
import com.tilak.apps.moshi.utilities.LogHelper

class ListFragment : Fragment() {

    companion object {
        var TAG = "ListFragment"
        fun newInstance() = ListFragment()
    }

    private lateinit var binding: ListFragmentBinding
    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //  return inflater.inflate(R.layout.list_fragment, container, false)
        binding = ListFragmentBinding.inflate(inflater, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.listAirlines.observe(viewLifecycleOwner, Observer
        {
            val airlinesName = StringBuilder()
            for (airline in it) {
                airlinesName.append(airline.name)
                    .append("\n")
            }
            LogHelper.logMessage(TAG, airlinesName.toString());
        })
    }

}