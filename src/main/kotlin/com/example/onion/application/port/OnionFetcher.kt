package com.example.onion.application.port

import com.example.onion.application.OnionDto

interface OnionFetcher {
    fun fetch(): OnionDto
}