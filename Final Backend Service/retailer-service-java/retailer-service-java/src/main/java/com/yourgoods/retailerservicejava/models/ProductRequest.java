package com.yourgoods.retailerservicejava.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("ProductRequests")
@JsonIgnoreProperties
public class ProductRequest {
    @Id
    private String requestId;
    private String retailerId;
    private String productId;
    private String productName;
    private int requestedProductQuantity;
    private String requestedDate;
    private Boolean isAccepted;
}
