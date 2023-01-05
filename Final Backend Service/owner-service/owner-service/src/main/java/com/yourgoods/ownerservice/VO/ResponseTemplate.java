package com.yourgoods.ownerservice.VO;

import com.yourgoods.ownerservice.entity.Owner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplate {

    private Owner owner;
    private Retailer retailer;
    private Inventory inventory;
}
