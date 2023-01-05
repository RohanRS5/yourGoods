package com.example.swaggerui.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(value = "OWNER-SERVICE",url = "http://localhost:4000/owner/")



public interface FeignServiceOwnerServiceUtil {
    @GetMapping("/owner")
    String getAllOwner();

}

