package com.mindera.dicechallenge.repository

import com.mindera.dicechallenge.api.IRandomApiClient
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

private const val NUM_LOWER_LIMIT = 1
private const val NUM_UPPER_LIMIT = 10000
private const val BOUNDS_LIMIT = 1000000000

@Suppress("IllegalIdentifier")
class RandomRepositoryUnitTest : KoinTest {

    private val randomRepository: RandomRepository by inject()

    @BeforeTest
    fun setup() {
        startKoin {
            modules(module {
                single<IRandomApiClient> { MockRandomApi() }
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

    @Test
    fun `test generateRandomInteger with valid num, lowerBound and upperBound`() {
        runBlocking {
            val result = randomRepository.generateRandomInteger(NUM_LOWER_LIMIT, 1, 10)
            val expected = listOf(5)
            assertEquals(expected, result)
        }
    }

    @Test
    fun `test generateRandomInteger with invalid num less than range`() {
        runBlocking {
            val result = randomRepository.generateRandomInteger(NUM_LOWER_LIMIT - 1, 1, 10)
            val expected = listOf<Int>()
            assertEquals(expected, result)
        }
    }

    @Test
    fun `test generateRandomInteger with invalid num more than range`() {
        runBlocking {
            val result = randomRepository.generateRandomInteger(NUM_UPPER_LIMIT + 1, 1, 10)
            val expected = listOf<Int>()
            assertEquals(expected, result)
        }
    }

    @Test
    fun `test generateRandomInteger with invalid lowerBound and upperBound`() {
        runBlocking {
            val result = randomRepository.generateRandomInteger(1, 10, 1)
            val expected = listOf<Int>()
            assertEquals(expected, result)
        }
    }

    @Test
    fun `test generateRandomInteger with invalid lowerBound more than range`() {
        runBlocking {
            val result = randomRepository.generateRandomInteger(1, BOUNDS_LIMIT + 1, 10)
            val expected = listOf<Int>()
            assertEquals(expected, result)
        }
    }

    @Test
    fun `test generateRandomInteger with invalid lowerBound less than range`() {
        runBlocking {
            val result = randomRepository.generateRandomInteger(1, -BOUNDS_LIMIT - 1, 1)
            val expected = listOf<Int>()
            assertEquals(expected, result)
        }
    }

    @Test
    fun `test generateRandomInteger with invalid upperBound more than range`() {
        runBlocking {
            val result = randomRepository.generateRandomInteger(1, 1, BOUNDS_LIMIT + 1)
            val expected = listOf<Int>()
            assertEquals(expected, result)
        }
    }

    @Test
    fun `test generateRandomInteger with invalid upperBound less than range`() {
        runBlocking {
            val result = randomRepository.generateRandomInteger(1, 1, -BOUNDS_LIMIT - 1)
            val expected = listOf<Int>()
            assertEquals(expected, result)
        }
    }

}