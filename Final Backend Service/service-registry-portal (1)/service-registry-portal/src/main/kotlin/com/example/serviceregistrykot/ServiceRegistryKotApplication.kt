package com.example.serviceregistrykot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class ServiceRegistryKotApplication

fun main(args: Array<String>) {
	runApplication<ServiceRegistryKotApplication>(*args)
}
