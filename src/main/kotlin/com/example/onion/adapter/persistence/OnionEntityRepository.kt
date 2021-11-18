package com.example.onion.adapter.persistence

import com.example.onion.application.OnionDto
import com.example.onion.application.port.OnionRepository

interface OnionEntityRepository: OnionRepository {
    override fun save(onionDto: OnionDto): OnionDto
}