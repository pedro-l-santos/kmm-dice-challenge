package com.mindera.dicechallenge.repository

import com.mindera.dicechallenge.api.RandomApi
import com.mindera.dicechallenge.mocks.MockRandomApi
import kotlinx.coroutines.runBlocking
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@Suppress("IllegalIdentifier")
class RandomRepositoryUnitTest : KoinTest {

    private val randomRepository: RandomRepository by inject()

    @BeforeTest
    fun setup() {
        startKoin {
            modules(module {
                single<RandomApi> { MockRandomApi() }
                single { RandomRepository() }
            })
        }
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun `test rollDice with valid numFaces`() {
        runBlocking {
            val result = randomRepository.rollDice(10)
            val expected = 5
            assertEquals(expected, result)
        }
    }

    @Test
    fun `test rollDice with invalid numFaces`() {
        runBlocking {
            val result = randomRepository.rollDice(0)
            val expected = ERROR_VALUE
            assertEquals(expected, result)
        }
    }

}