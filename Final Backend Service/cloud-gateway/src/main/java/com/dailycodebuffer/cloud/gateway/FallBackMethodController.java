package com.dailycodebuffer.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/inventoryServiceFallBack")
    public String inventoryServiceFallBackMethod() {
        return "Inventory Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/retailerServiceFallBack")
    public String retailerServiceFallBackMethod() {
        return "Retailer Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/ownerServiceFallBack")
    public String ownerServiceFallBackMethod() {
        return "Owner Service is taking longer than Expected." +
                " Please try again later";
    }
}
