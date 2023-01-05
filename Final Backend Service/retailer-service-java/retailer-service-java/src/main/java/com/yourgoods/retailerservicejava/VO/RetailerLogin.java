package com.yourgoods.retailerservicejava.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetailerLogin {
    private String retailerEmail;
    private String retailerPassword;
}
