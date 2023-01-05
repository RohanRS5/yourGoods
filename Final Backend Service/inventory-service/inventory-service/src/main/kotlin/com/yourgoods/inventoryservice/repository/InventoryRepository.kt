package com.yourgoods.inventoryservice.repository

import com.yourgoods.inventoryservice.entity.Inventory
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface InventoryRepository : MongoRepository<Inventory, String>