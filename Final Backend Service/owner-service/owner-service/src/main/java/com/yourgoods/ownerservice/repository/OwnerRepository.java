package com.yourgoods.ownerservice.repository;

import com.yourgoods.ownerservice.entity.Owner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends MongoRepository<Owner, String> {

    Owner findByOwnerId(String productId, String retailerId);

    Optional<Owner> findOwnerByOwnerId(String ownerId);

    Optional<Owner> findOwnerByOwnerEmail(String ownerEmail);



    //Optional<Owner> findOwnerByOwnerId(String agentId);




}

