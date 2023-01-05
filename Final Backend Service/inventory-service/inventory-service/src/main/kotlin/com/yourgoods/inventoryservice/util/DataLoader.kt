package com.yourgoods.inventoryservice.util

import com.yourgoods.inventoryservice.entity.Inventory


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.client.RestTemplate

public class DataLoader {
    @Autowired
    private var inventory: Inventory = Inventory()

    @Autowired
    private val restTemplate: RestTemplate = RestTemplate()
    fun loadData(){
        inventory.setProductId("PRMO001")
        inventory.setProductAmount("50000")
        inventory.setProductCategory("Mobiles")
        inventory.setProductName("Samsung S20")
        inventory.setProductQuantity(30)
        restTemplate.postForObject("http://localhost:4004/inventory/save",inventory,Inventory::class.java)
        println("Data Loaded")

        inventory.setProductId("PRMO002")
        inventory.setProductAmount("38000")
        inventory.setProductCategory("Mobiles")
        inventory.setProductName("OnePlus 9T")
        inventory.setProductQuantity(15)
        restTemplate.postForObject("http://localhost:4004/inventory/save",inventory,Inventory::class.java)
        println("Data Loaded")

        inventory.setProductId("PRMO003")
        inventory.setProductAmount("70000")
        inventory.setProductCategory("Mobiles")
        inventory.setProductName("Iphone 14")
        inventory.setProductQuantity(50)
        restTemplate.postForObject("http://localhost:4004/inventory/save",inventory,Inventory::class.java)
        println("Data Loaded")

        inventory.setProductId("PRMO004")
        inventory.setProductAmount("21000")
        inventory.setProductCategory("Mobiles")
        inventory.setProductName("Motorola G30")
        inventory.setProductQuantity(13)
        restTemplate.postForObject("http://localhost:4004/inventory/save",inventory,Inventory::class.java)
        println("Data Loaded")

        //Laptops
        inventory.setProductId("PRLA001")
        inventory.setProductAmount("55000")
        inventory.setProductCategory("Laptops")
        inventory.setProductName("Hp Notebook ultra")
        inventory.setProductQuantity(80)
        restTemplate.postForObject("http://localhost:4004/inventory/save",inventory,Inventory::class.java)
        println("Data Loaded")

        inventory.setProductId("PRLA002")
        inventory.setProductAmount("42000")
        inventory.setProductCategory("Laptops")
        inventory.setProductName("Lenovo Ideapad S1")
        inventory.setProductQuantity(45)
        restTemplate.postForObject("http://localhost:4004/inventory/save",inventory,Inventory::class.java)
        println("Data Loaded")

        inventory.setProductId("PRLA003")
        inventory.setProductAmount("35000")
        inventory.setProductCategory("Laptops")
        inventory.setProductName("Asus Zenbook")
        inventory.setProductQuantity(130)
        restTemplate.postForObject("http://localhost:4004/inventory/save",inventory,Inventory::class.java)
        println("Data Loaded")

        inventory.setProductId("PRLA004")
        inventory.setProductAmount("83000")
        inventory.setProductCategory("Laptops")
        inventory.setProductName("Dell Inspiron")
        inventory.setProductQuantity(62)
        restTemplate.postForObject("http://localhost:4004/inventory/save",inventory,Inventory::class.java)
        println("Data Loaded")

        //Audio

        inventory.setProductId("PRAD001")
        inventory.setProductAmount("7000")
        inventory.setProductCategory("Earphones")
        inventory.setProductName("Samsung Earbuds")
        inventory.setProductQuantity(90)
        restTemplate.postForObject("http://localhost:4004/inventory/save",inventory,Inventory::class.java)
        println("Data Loaded")

        inventory.setProductId("PRAD002")
        inventory.setProductAmount("4500")
        inventory.setProductCategory("Earphones")
        inventory.setProductName("OnePlus Buds")
        inventory.setProductQuantity(100)
        restTemplate.postForObject("http://localhost:4004/inventory/save",inventory,Inventory::class.java)
        println("Data Loaded")

        inventory.setProductId("PRAD003")
        inventory.setProductAmount("9000")
        inventory.setProductCategory("Earphones")
        inventory.setProductName("Sony MX")
        inventory.setProductQuantity(57)
        restTemplate.postForObject("http://localhost:4004/inventory/save",inventory,Inventory::class.java)
        println("Data Loaded")

        inventory.setProductId("PRAD004")
        inventory.setProductAmount("8000")
        inventory.setProductCategory("Earphones")
        inventory.setProductName("JBL EarBuds")
        inventory.setProductQuantity(170)
        restTemplate.postForObject("http://localhost:4004/inventory/save",inventory,Inventory::class.java)
        println("Data Loaded")

        //Tablets

        inventory.setProductId("PRTA001")
        inventory.setProductAmount("24999")
        inventory.setProductCategory("Tablets")
        inventory.setProductName("Samsung Galaxy Tab S6")
        inventory.setProductQuantity(10)
        restTemplate.postForObject("http://localhost:4004/inventory/save",inventory,Inventory::class.java)
        println("Data Loaded")

        inventory.setProductId("PRTA002")
        inventory.setProductAmount("54900")
        inventory.setProductCategory("Tablets")
        inventory.setProductName("Apple iPad Air")
        inventory.setProductQuantity(8)
        restTemplate.postForObject("http://localhost:4004/inventory/save",inventory,Inventory::class.java)
        println("Data Loaded")

        inventory.setProductId("PRTA003")
        inventory.setProductAmount("19999")
        inventory.setProductCategory("Tablets")
        inventory.setProductName("Lenovo Yoga Smart Tab")
        inventory.setProductQuantity(19)
        restTemplate.postForObject("http://localhost:4004/inventory/save",inventory,Inventory::class.java)
        println("Data Loaded")

        inventory.setProductId("PRTA004")
        inventory.setProductAmount("23999")
        inventory.setProductCategory("Tablets")
        inventory.setProductName("Honor Pad 5")
        inventory.setProductQuantity(6)
        restTemplate.postForObject("http://localhost:4004/inventory/save",inventory,Inventory::class.java)
        println("Data Loaded")

    }

}