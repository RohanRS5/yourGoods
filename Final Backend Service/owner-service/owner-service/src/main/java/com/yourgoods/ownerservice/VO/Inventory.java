package com.yourgoods.ownerservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    private String productId;
    private String productName;
    private String productAmount;
    private String productCategory;
    private Integer productQuantity;
}
