package com.jait

class Store {

    String name
    String description

    //relation
    User user

    Set<Product> products = [] as Set<Product>

    static hasMany = [products: Product]

}
