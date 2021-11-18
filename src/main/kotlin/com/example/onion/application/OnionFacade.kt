package com.example.onion.application

import com.example.onion.application.port.OnionFetcher
import com.example.onion.application.port.OnionRepository
import com.example.onion.domain.service.OnionService
import java.util.*

class OnionFacade(
    private val onionRepository: OnionRepository,
    private val onionFetcher: OnionFetcher,
    private val onionService: OnionService,
) {

    fun create(dto: OnionDto): OnionDto {
        val fetched = onionFetcher.fetch()
        val onion = fetched.to(UUID.randomUUID())
        val created = onionService.create(onion)
        val mapped = OnionDto.from(created)
        return onionRepository.save(mapped)
    }
}