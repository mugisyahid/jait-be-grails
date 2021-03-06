package com.jait

class Store {

    String name
    String description

    List<String> bannerImage
    //relation
    User user

    Set<Product> products = [] as Set<Product>

    static hasMany = [products: Product]

    static constraints = {
        bannerImage nullable: true, blank: true
        products nullable: true, blank: true
    }
}
