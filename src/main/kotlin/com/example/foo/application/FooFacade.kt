package com.example.foo.application

import com.example.foo.event.FooCreated
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class FooFacade(private val publisher: ApplicationEventPublisher) {

    fun create(fooCreated: FooCreated) {
        publisher.publishEvent(fooCreated)
    }
}