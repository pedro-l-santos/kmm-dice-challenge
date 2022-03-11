package com.mindera.dicechallenge.mocks

import com.mindera.dicechallenge.api.IRandomApiClient

class MockRandomApi : IRandomApiClient {
    override suspend fun generateInteger(num: Int, lowerBound: Int, upperBound: Int): List<Int> {
        return listOf(5)
    }
}