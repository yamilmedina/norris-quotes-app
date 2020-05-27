package io.github.yamilmedina.viperapp.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

abstract class CoroutineContextProvider {
    open val main: CoroutineDispatcher by lazy { Dispatchers.Main }
    open val default: CoroutineDispatcher by lazy { Dispatchers.Default }
    open val io: CoroutineDispatcher by lazy { Dispatchers.IO }
    open val unconfined: CoroutineDispatcher by lazy { Dispatchers.Unconfined }
}

class DefaultCoroutineContextProvider : CoroutineContextProvider()