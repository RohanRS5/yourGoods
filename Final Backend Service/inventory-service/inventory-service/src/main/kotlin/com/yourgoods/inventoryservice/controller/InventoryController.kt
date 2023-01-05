package com.yourgoods.inventoryservice.controller


import com.yourgoods.inventoryservice.entity.Inventory
import com.yourgoods.inventoryservice.repository.InventoryRepository
import com.yourgoods.inventoryservice.service.InventoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/inventory")
@CrossOrigin(origins = ["*"])
public class InventoryController (private val inventoryRepository: InventoryRepository){

    @Autowired
    private val inventoryService: InventoryService? = null

    @PostMapping("/save")
    fun saveInventory(@RequestBody inventory: Inventory): Inventory { return this.inventoryRepository.save(inventory)
    }
    @GetMapping("/findall")
    fun getAllInventory(): List<Inventory> { return this.inventoryRepository.findAll() }
    @GetMapping("/findallbyid/{productId}")
    fun getInventoryByProductId(@PathVariable productId: String): Inventory? {
        var inventories: List<Inventory> = getAllInventory()
        for (inventory in inventories) {
            if (inventory.getProductId().equals(productId)) {
                return inventory
            }
        }
        return null
    }
    @GetMapping("/findallbycategory/{productCategory}")
    fun getInventoryByProductCategory(@PathVariable productCategory: String): ArrayList<Inventory> {
        var inventories: List<Inventory> = getAllInventory()
        var inventoryCategory = ArrayList<Inventory>()
        for (inventory in inventories) {
            if (inventory.getProductCategory().equals(productCategory)) {
                inventoryCategory.add(inventory)
            }
        }
        return inventoryCategory
    }

    @GetMapping("/findallbyproductName/{productName}")
    fun getInventoryByProductName(@PathVariable productName: String): ArrayList<Inventory> {
        var inventories: List<Inventory> = getAllInventory()
        var inventoryName = ArrayList<Inventory>()
        for (inventory in inventories) {
            if (inventory.getProductName().equals(productName)) {
                inventoryName.add(inventory)
            }
        }
        return inventoryName
    }

//    @PutMapping("/update/{id}")
//    fun updateProductById(@PathVariable("id") productId: String?, @RequestBody inventory: Inventory): Inventory? {
//        val inventoryData: Optional<Inventory> = Optional.ofNullable(inventoryService?.findInventoryById(productId))
//        if (inventoryData.isPresent()) {
//
//            val _inventory: Inventory = inventoryData.get()
//           // _inventory.setLicenseId(license.getLicenseId())
//            _inventory.setProductName(inventory.getProductName())
//            _inventory.setProductQuantity(inventory.getProductQuantity())
//            _inventory.setProductAmount(inventory.getProductAmount())
//            return inventoryService?.saveInventory(_inventory)
//        }
//        return inventoryService(HttpStatus.NOT_FOUND)
//    }

    @PutMapping("/updateinventory/{id}")
    fun updateProductById(@PathVariable("id") productId: String, @RequestBody inventory: Inventory): ResponseEntity<Inventory>{

        var oldInventory = this.inventoryRepository.findById(productId).orElse(null)
        oldInventory.productName = inventory.productName
        oldInventory.productQuantity= inventory.productQuantity
        oldInventory.productAmount= inventory.productAmount
        oldInventory.productCategory=inventory.productCategory

        return ResponseEntity.ok(this.inventoryRepository.save(oldInventory))
    }

    @DeleteMapping("/deleteinventory/{id}")
    fun deleteProductById(@PathVariable("id") productId: String?) {
        if (productId != null) {
            inventoryRepository?.deleteById(productId)
        }
    }

    private fun inventoryService(notFound: HttpStatus): Inventory? {
        return inventoryService(HttpStatus.NOT_FOUND)
    }

}