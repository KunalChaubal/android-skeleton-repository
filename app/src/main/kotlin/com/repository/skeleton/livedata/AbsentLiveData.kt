package com.repository.skeleton.livedata

import androidx.lifecycle.LiveData

/**
 * A LiveData class that has `null` value.
 */
class AbsentLiveData<T> private constructor() : LiveData<T>() {

    init {
        postValue(null)
    }

    companion object {
        /**
         *  Factory method
         */
        fun <T> create(): LiveData<T> = AbsentLiveData()
    }
}