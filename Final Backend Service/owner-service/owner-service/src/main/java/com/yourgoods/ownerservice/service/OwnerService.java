package com.yourgoods.ownerservice.service;

import com.yourgoods.ownerservice.VO.Inventory;
import com.yourgoods.ownerservice.VO.ProductRequest;
import com.yourgoods.ownerservice.VO.ResponseTemplate;
import com.yourgoods.ownerservice.VO.Retailer;
import com.yourgoods.ownerservice.entity.Owner;
import com.yourgoods.ownerservice.repository.OwnerRepository;
import com.yourgoods.ownerservice.repository.ProductRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class OwnerService {

    private OwnerRepository ownerRepository;
    private ProductRequestRepo productRequestRepo;

    @Autowired
    private RestTemplate restTemplate;
    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Autowired
    public OwnerService(OwnerRepository ownerRepository, ProductRequestRepo productRequestRepo) {
        this.ownerRepository = ownerRepository;
        this.productRequestRepo = productRequestRepo;
    }

    public String signin(Owner owner) {
        System.out.println(owner.getOwnerEmail());
        System.out.println(owner.getOwnerPassword());
        if (owner.getOwnerEmail().equals("rohan@gmail.com") && owner.getOwnerPassword().equals("Rrs@121212")) {
            return "valid";
        } else if (owner.getOwnerEmail().equals("sania@gmail.com") && owner.getOwnerPassword().equals("sania")) {
            return "valid";
        } else if (owner.getOwnerEmail().equals("arya@gmail.com") && owner.getOwnerPassword().equals("arya")) {
            return "valid";
        } else {
            return "Invalid";
        }
    }


    public ResponseTemplate getOwnerWithRetailerInventory(String retailerId, String productId) {
        ResponseTemplate rtVO = new ResponseTemplate();
        Owner owner = ownerRepository.findByOwnerId(retailerId, productId);
        Retailer retailer = restTemplate.getForObject("http://localhost:4001/api/retailer/" + owner.getRetailerId(), Retailer.class);
        Inventory inventory = restTemplate.getForObject("http://localhost:4004/inventory/" + owner.getProductId(), Inventory.class);
        rtVO.setOwner(owner);
        rtVO.setRetailer(retailer);
        rtVO.setInventory(inventory);
        return rtVO;
    }

    public List<Owner> getAllOwner() {
        return ownerRepository.findAll();
    }

    public ResponseEntity<Boolean> productRequestAction(String reqId) {
        ProductRequest productRequest = restTemplate.getForObject("http://localhost:4001/api/retailer/productrequest/"+reqId,ProductRequest.class);
        Inventory inventory = restTemplate.getForObject("http://localhost:4004/inventory/findallbyid/"+productRequest.getProductId(),Inventory.class);
        System.out.println(inventory);
        System.out.println(productRequest);
        Integer newQuantity = inventory.getProductQuantity() - productRequest.getRequestedProductQuantity();
        System.out.println(newQuantity);
        inventory.setProductQuantity(newQuantity);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Inventory> entity = new HttpEntity<Inventory>(inventory,headers);
        restTemplate.exchange(
        "http://localhost:4004/inventory/updateinventory/"+inventory.getProductId(), HttpMethod.PUT, entity, String.class).getBody();
        productRequest.setIsAccepted(Boolean.TRUE);
        productRequestRepo.save(productRequest);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    public ResponseEntity<Boolean> productRequestReject(String reqId) {
        ProductRequest productRequest = restTemplate.getForObject("http://localhost:4001/api/retailer/productrequest/"+reqId,ProductRequest.class);
        productRequest.setIsAccepted(Boolean.FALSE);
        productRequestRepo.save(productRequest);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }
}
