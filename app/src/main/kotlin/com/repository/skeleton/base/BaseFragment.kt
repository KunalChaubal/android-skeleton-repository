package com.repository.skeleton.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * Base Fragment for the entire app
 */
abstract class BaseFragment : Fragment() {

    /**
     *  Provides layout id to be inflated
     */
    @LayoutRes
    abstract fun layoutId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(layoutId(), container, false)
}