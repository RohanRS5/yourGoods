package com.yourgoods.ownerservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("product_requests")
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
