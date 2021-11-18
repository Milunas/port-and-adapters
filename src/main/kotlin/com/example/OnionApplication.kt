package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OnionApplication

fun main(args: Array<String>) {
	runApplication<OnionApplication>(*args)
}
