package com.yourgoods.retailerservicejava.repository;

import com.yourgoods.retailerservicejava.models.Retailer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RetailerRepository extends MongoRepository<Retailer, String> {
    Retailer findByRetailerId(String retailerId);

    Boolean deleteByRetailerId(String retailerId);

    Optional<Retailer> findByRetailerEmail(String retailerEmail);
}
