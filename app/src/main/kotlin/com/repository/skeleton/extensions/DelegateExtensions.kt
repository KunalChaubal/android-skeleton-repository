package com.repository.skeleton.extensions


fun <T> lazyN(initializer: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initializer)