package com.example.onion.adapter.external

import com.example.misc.client.HttpClient
import com.example.onion.application.OnionDto
import com.example.onion.application.port.OnionFetcher

interface OnionFetcher : OnionFetcher {
    override fun fetch(): OnionDto
}

class OnionFetcherImpl(private val client: HttpClient): OnionFetcher {
    override fun fetch(): OnionDto = TODO("Not yet implemented")
}