package com.repository.skeleton.ui

import android.os.Bundle
import com.repository.skeleton.R
import com.repository.skeleton.base.DataBindingActivity
import com.repository.skeleton.databinding.ActivityMainBinding
import com.repository.skeleton.extensions.addFragment
import com.repository.skeleton.ui.example.FetchDetailsFragment
import org.koin.android.ext.android.inject

class MainActivity : DataBindingActivity<ActivityMainBinding>() {

    private val mainVM by inject<MainVM>()

    override fun layoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb.vm = mainVM

        addFragment(
            FetchDetailsFragment.newInstance(),
            vb.container.id,
            FetchDetailsFragment.TAG
        )
    }
}