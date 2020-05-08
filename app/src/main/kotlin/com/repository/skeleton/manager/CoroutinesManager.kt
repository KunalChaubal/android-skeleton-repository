package com.repository.skeleton.manager

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class CoroutinesManager {

    private val supervisorJob = SupervisorJob()

    /**
     * This is a scope for all coroutines
     * that will be dispatched in a Thread Pool
     */
    val ioScope = CoroutineScope(Dispatchers.Default + supervisorJob)
}