package com.example.onion.domain.service

import com.example.onion.domain.model.Onion
import com.example.onion.domain.model.OnionFactory
import com.example.onion.domain.model.OnionPolicy

class OnionService(
    private val factory: OnionFactory,
) {

    fun create(onion: Onion): Onion {
        val value = onion.value.valid()
        val policy = OnionPolicy()
        return factory.from(onion, value, policy)
    }
}