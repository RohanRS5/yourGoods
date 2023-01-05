package com.yourgoods.retailerservicejava.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Document("Retailer")
@JsonIgnoreProperties
public class Retailer {

    @Id
    private String retailerId;
    @NotBlank
    private String retailerName;
    @NotBlank
    private String retailerEmail;
    @NotBlank
    private String retailerPassword;
    @NotBlank
    private String retailerPhone;
    @NotBlank
    private String retailerAddress;
    @NotBlank
    private String retailerPincode;
//    public void setRetailerPassword(String retailerPassword) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        this.retailerPassword = encoder.encode(retailerPassword);
//    }
}
