package com.example.onion.application

import com.example.foo.event.FooCreated
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class FooHandler {

    @EventListener
    fun handle(foo: FooCreated): Unit = TODO()
}