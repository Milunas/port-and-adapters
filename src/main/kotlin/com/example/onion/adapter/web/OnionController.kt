package com.example.onion.adapter.web

import com.example.onion.application.OnionDto
import com.example.onion.application.OnionFacade
import com.example.onion.application.port.OnionRepository

class OnionController(
    private val facade: OnionFacade,
    private val repository: OnionRepository,
) {

    fun create(onionDto: OnionDto): OnionDto = TODO()
}