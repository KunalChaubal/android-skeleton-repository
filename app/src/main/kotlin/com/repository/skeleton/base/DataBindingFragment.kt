package com.repository.skeleton.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * BaseFragment for keeping an instance of [ViewDataBinding]
 */
abstract class DataBindingFragment<VB : ViewDataBinding> : BaseFragment() {

    lateinit var vb: VB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        vb = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        return vb.root
    }

}