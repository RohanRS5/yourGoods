package com.yourgoods.ownerservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Owner")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Owner {

    @Id
    @Indexed(unique = true)
    private String ownerId;

    private String ownerEmail;

    private String ownerPassword;

    public String retailerId;
    public String productId;
}
