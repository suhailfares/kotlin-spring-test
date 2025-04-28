package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}


// This is the main application for Spring startup, most of the time you won't need to add anything here, but when working
// on some features you might need to add Config classes here.