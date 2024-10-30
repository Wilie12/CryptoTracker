package com.willaapps.cryptotracker.crypto.domain

import com.willaapps.cryptotracker.core.domain.util.NetworkError
import com.willaapps.cryptotracker.core.domain.util.Result

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}