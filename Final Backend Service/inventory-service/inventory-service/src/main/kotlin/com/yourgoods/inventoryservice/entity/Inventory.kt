package com.yourgoods.inventoryservice.entity


import lombok.*
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("Inventory")
public class Inventory {
    @Indexed(unique=true)
    @Id
    private var productId: String? = null
    internal var productName: String? = null
    internal var productAmount: String? = null
    internal var productCategory: String? = null
    internal var productQuantity: Int? = null


    fun setProductId(productId:String){
        this.productId = productId
    }
    fun getProductId(): String? {
        return productId
    }

    fun setProductName(productName:String){
        this.productName = productName
    }
    fun getProductName(): String? {
        return productName
    }

    fun setProductAmount(productAmount:String){
        this.productAmount = productAmount
    }
    fun getProductAmount(): String? {
        return productAmount
    }

    fun setProductCategory(productCategory:String){
        this.productCategory = productCategory
    }
    fun getProductCategory(): String? {
        return productCategory
    }

    fun setProductQuantity(productQuantity:Int){
        this.productQuantity = productQuantity
    }
    fun getProductQuantity(): Int? {
        return productQuantity
    }

    override fun toString(): String {
        return "Inventory(productId='$productId', productName='$productName', productAmount='$productAmount', productCategory='$productCategory', productQuantity= '$productQuantity')"
    }


}