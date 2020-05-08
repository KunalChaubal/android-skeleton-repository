package com.repository.skeleton.ui.utils

import android.content.Context
import androidx.annotation.*


class ResourceProvider(private val context: Context) {

    fun getString(@StringRes resId: Int): String {
        return context.getString(resId)
    }
}
