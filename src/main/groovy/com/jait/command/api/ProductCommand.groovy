package com.jait.command.api

import grails.validation.Validateable

class ProductCommand implements Validateable {

    String name
    BigDecimal price
    String description
    String imageName
    BigInteger quantity
    BigInteger viewCount = 0
    double rating = 0

    //entity
    Long storeId;
    Long productCategoryId;
}
