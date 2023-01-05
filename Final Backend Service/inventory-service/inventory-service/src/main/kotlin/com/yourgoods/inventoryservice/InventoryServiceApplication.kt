package com.yourgoods.inventoryservice

import com.yourgoods.inventoryservice.util.DataLoader
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
public class InventoryServiceApplication

fun main(args: Array<String>) {
	var dl : DataLoader = DataLoader()


	runApplication<InventoryServiceApplication>(*args)
	dl.loadData()
}
