package com.example.swaggerui.controller;


import com.example.swaggerui.util.FeignServiceInventoryServiceUtil;
import com.example.swaggerui.util.FeignServiceRetailerServiceUtil;
import com.example.swaggerui.util.FeignServiceOwnerServiceUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/swagger")

public class FeignController {

    /*----------------------------------INVENTORY SERVICE  -------------------------------------------*/

    @Autowired
    private FeignServiceInventoryServiceUtil feignServiceInventoryServiceUtil;
    @GetMapping("/inventory/save")
    public String getInventoryByProductId(){return feignServiceInventoryServiceUtil.getInventoryByProductId();
    }

    /*----------------------------------RETAILER SERVICE  -------------------------------------------*/


   

    @Autowired
    private FeignServiceRetailerServiceUtil feignServiceRetailerServiceUtil;

    @GetMapping("/api/retailer")
    public String  getRetailerById(){return feignServiceRetailerServiceUtil.getRetailerById();}





    /*----------------------------------OWNER SERVICE  -------------------------------------------*/



    @Autowired
    private FeignServiceOwnerServiceUtil feignServiceOwnerServiceUtil;

    @GetMapping("/owner")
    public String getAllOwner(){
        return feignServiceOwnerServiceUtil.getAllOwner();
    }




}
