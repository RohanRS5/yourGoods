package com.yourgoods.ownerservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Retailer {

    private String retailerId;
    private String retailerName;
    private String retailerEmail;
    private String retailerPassword;
    private String retailerPhone;
    private String retailerAddress;
    private String retailerPincode;

}
