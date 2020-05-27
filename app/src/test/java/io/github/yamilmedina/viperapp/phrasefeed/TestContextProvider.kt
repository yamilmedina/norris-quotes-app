package io.github.yamilmedina.viperapp.phrasefeed

import io.github.yamilmedina.viperapp.utils.CoroutineContextProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher

@ExperimentalCoroutinesApi
class TestContextProvider(
        val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher())
    : CoroutineContextProvider() {

    override val main: CoroutineDispatcher = testDispatcher
    override val io: CoroutineDispatcher = testDispatcher
    override val unconfined: CoroutineDispatcher = testDispatcher
    override val default: CoroutineDispatcher = testDispatcher
}