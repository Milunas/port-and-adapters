package com.example.onion.application.port

import com.example.onion.application.OnionDto

interface OnionRepository {
    fun save(onionDto: OnionDto): OnionDto
}