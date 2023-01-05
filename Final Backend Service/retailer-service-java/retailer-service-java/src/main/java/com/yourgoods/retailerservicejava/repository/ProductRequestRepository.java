package com.yourgoods.retailerservicejava.repository;

import com.yourgoods.retailerservicejava.models.ProductRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRequestRepository extends MongoRepository<ProductRequest, String> {
}
