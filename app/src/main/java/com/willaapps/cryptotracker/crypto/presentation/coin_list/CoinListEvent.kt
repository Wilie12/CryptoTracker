package com.willaapps.cryptotracker.crypto.presentation.coin_list

import com.willaapps.cryptotracker.core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError): CoinListEvent
}