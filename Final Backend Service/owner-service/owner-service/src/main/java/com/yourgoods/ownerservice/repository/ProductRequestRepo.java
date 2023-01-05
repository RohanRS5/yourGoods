package com.yourgoods.ownerservice.repository;

import com.yourgoods.ownerservice.VO.ProductRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRequestRepo extends MongoRepository<ProductRequest, String> {
}
