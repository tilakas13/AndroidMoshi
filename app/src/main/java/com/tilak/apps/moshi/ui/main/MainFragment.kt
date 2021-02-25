package com.tilak.apps.moshi.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tilak.apps.moshi.R
import com.tilak.apps.moshi.databinding.MainFragmentBinding
import com.tilak.apps.moshi.utilities.AppConstants
import com.tilak.apps.moshi.utilities.LogHelper
import com.tilak.apps.moshi.utilities.SourceType

class MainFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater, container, false);
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.butLoadFromAssets.setOnClickListener(this)
        binding.butLoadFromResource.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.but_load_from_assets -> {
                LogHelper.logMessage(AppConstants.TAG_LOGS, "Load data from Assets")
                val actionSourceType =
                    MainFragmentDirections.actionMainFragmentToListFragment(SourceType.ASSETS)
                findNavController().navigate(actionSourceType)
            }

            R.id.but_load_from_resource -> {
                LogHelper.logMessage(AppConstants.TAG_LOGS, "Load data from resource")
                val actionSourceType =
                    MainFragmentDirections.actionMainFragmentToListFragment(SourceType.RESOURCE)
                findNavController().navigate(actionSourceType)
            }
        }


    }


}