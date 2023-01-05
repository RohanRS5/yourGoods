package com.example.swaggerui.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(value = "INVENTORY-SERVICE",url = "http://localhost:4004/inventory/save")



public interface FeignServiceInventoryServiceUtil {
    @GetMapping("/inventory/save")
    String getInventoryByProductId();

}
