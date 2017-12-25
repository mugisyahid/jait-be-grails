package com.jait

class Product {

    String name
    BigDecimal price
    String description

    static belongsTo = [user: User]

    static constraints = {
    }
}
