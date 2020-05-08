package com.repository.skeleton.ui.example

import android.os.Bundle
import androidx.lifecycle.Observer
import com.repository.skeleton.R
import com.repository.skeleton.base.DataBindingFragment
import com.repository.skeleton.databinding.FragmentFetchDetailsBinding
import org.koin.android.ext.android.inject


class FetchDetailsFragment : DataBindingFragment<FragmentFetchDetailsBinding>() {

    private val vm by inject<FetchDetailsViewModel>()

    companion object {
        const val TAG  = "FetchDogsFragment"
        fun newInstance() =
            FetchDetailsFragment()
    }

    override fun layoutId() = R.layout.fragment_fetch_details

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vb.vm = vm
        initObservers()
        vm.makeNetworkCall()
    }

    private fun initObservers() {
        vm.updateEvent.observe(viewLifecycleOwner, Observer {
            // Update UI here
        })
    }

}
