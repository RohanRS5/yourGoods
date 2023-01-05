package com.yourgoods.ownerservice.controller;

import com.yourgoods.ownerservice.VO.Inventory;
import com.yourgoods.ownerservice.VO.Retailer;
import com.yourgoods.ownerservice.entity.Owner;
import com.yourgoods.ownerservice.repository.OwnerRepository;
import com.yourgoods.ownerservice.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/owner")
@CrossOrigin(origins = "*")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<Owner> getAllOwner() {
        return ownerService.getAllOwner();
    }

    @PostMapping("/")
    public Owner saveOwner(@RequestBody Owner owner) {
        return ownerService.saveOwner(owner);
    }

////////////////////////////////////////SIGN  IN///////////////////////////////////////////////////////////////////

    @PostMapping(path = "/signin")
    public String signin(@RequestBody Owner Owner) {
        System.out.println(Owner.getOwnerEmail());
        System.out.println(Owner.getOwnerPassword());
        return ownerService.signin(Owner);
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////REST ON RETAILER//////////////////////////////////////////////////////////

    @RequestMapping(value = "/getallretailers")
    public String getRetailerList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:4001/api/retailer/getall", HttpMethod.GET, entity, String.class).getBody();


    }

    @RequestMapping(value = "/getretailer/{id}")
    public String getRetailerById(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:4001/api/retailer/"+id, HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping(value = "/updateretailer/{id}", method = RequestMethod.PUT)
    public String updateRetailer(@PathVariable("id") String id, @RequestBody Retailer retailer) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Retailer> entity = new HttpEntity<Retailer>(retailer,headers);

        return restTemplate.exchange(
                "http://localhost:4001/api/retailer/"+id, HttpMethod.PUT, entity, String.class).getBody();
    }

    @RequestMapping(value = "/deleteretailer/{id}", method = RequestMethod.DELETE)
    public String deleteRetailerById(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Retailer> entity = new HttpEntity<Retailer>(headers);

        return restTemplate.exchange(
                "http://localhost:4001/api/retailer/"+id, HttpMethod.DELETE, entity, String.class).getBody();
    }
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////// I N V E N T O R Y /////////////////////////////////////////////////

    @RequestMapping(value = "/getallinventory")
    public String getAllInventory() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:4004/inventory/findall", HttpMethod.GET, entity, String.class).getBody();


    }

    @RequestMapping(value = "/getinventory/{id}")
    public String getInventoryById(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:4004/inventory/findallbyid/"+id, HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping(value = "/{productCategory}", method = RequestMethod.GET)
    public String getInventoryByCategory(@PathVariable String productCategory) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:4004/inventory/findallbycategory/"+productCategory, HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public String createProducts(@RequestBody Inventory inventory) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Inventory> entity = new HttpEntity<Inventory>(inventory,headers);

        return restTemplate.exchange(
                "http://localhost:4004/inventory/save", HttpMethod.POST, entity, String.class).getBody();
    }

    @RequestMapping(value = "/updateinventory/{id}", method = RequestMethod.PUT)
    public String updateProductById(@PathVariable("id") String id, @RequestBody Inventory inventory) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Inventory> entity = new HttpEntity<Inventory>(inventory,headers);

        return restTemplate.exchange(
                "http://localhost:4004/inventory/updateinventory/"+id, HttpMethod.PUT, entity, String.class).getBody();
    }


    @RequestMapping(value = "/{productName}", method = RequestMethod.GET)
    public String getInventoryByProductName(@PathVariable String productName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("http://localhost:4004/inventory/findallbyproductName/"+productName, HttpMethod.GET, entity, String.class).getBody();
    }

    @PutMapping("/productRequestAccept/{requestId}")
    public ResponseEntity<Boolean> productRequestAccept(@PathVariable("requestId") String reqId){
        return ownerService.productRequestAction(reqId);
    }

    @PutMapping("/productRequestReject/{requestId}")
    public ResponseEntity<Boolean> productRequestReject(@PathVariable("requestId") String reqId){
        return ownerService.productRequestReject(reqId);
    }



}

