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
import com.tilak.apps.moshi.utilities.LogHelper

class MainFragment : Fragment(), View.OnClickListener {

    companion object {
        const val TAG = "MainFragment"
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
                LogHelper.logMessage(TAG, "Load data from Assets")
                findNavController().navigate(R.id.action_mainFragment_to_listFragment)
            }

            R.id.but_load_from_resource -> {
                LogHelper.logMessage(TAG, "Load data from resource")
                findNavController().navigate(R.id.action_mainFragment_to_listFragment)
            }
        }
    }


}