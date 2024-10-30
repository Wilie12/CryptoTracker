package com.willaapps.cryptotracker.crypto.data.networking

import com.willaapps.cryptotracker.core.data.networking.constructUrl
import com.willaapps.cryptotracker.core.data.networking.safeCall
import com.willaapps.cryptotracker.core.domain.util.NetworkError
import com.willaapps.cryptotracker.core.domain.util.Result
import com.willaapps.cryptotracker.core.domain.util.map
import com.willaapps.cryptotracker.crypto.data.mappers.toCoin
import com.willaapps.cryptotracker.crypto.data.networking.dto.CoinsResponseDto
import com.willaapps.cryptotracker.crypto.domain.Coin
import com.willaapps.cryptotracker.crypto.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val client: HttpClient
): CoinDataSource {

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            client.get(
                urlString = constructUrl("/assets")
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }
}