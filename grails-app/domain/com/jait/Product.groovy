package com.jait

import com.jait.command.api.ProductCommand
import org.joda.time.LocalDateTime

class Product {

    String name
    BigDecimal price
    String description
    String imageName
    BigInteger quantity
    BigInteger viewCount = 0
    double rating = 0
    Long createdTime

    ProductCategory productCategory

    Product (ProductCommand cmd){
        this.name = cmd.name
        this.price = cmd.price
        this.description = cmd.description
        this.imageName = cmd.imageName
        this.quantity = cmd.quantity
        this.createdTime = new LocalDateTime().toDate().getTime()
    }

    static belongsTo = [store: Store]

    static constraints = {
    }
}
