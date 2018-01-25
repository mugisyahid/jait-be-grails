package com.jait

/**
 * Created by zeldris on 25/12/17.
 */
class ProductOrder {

    Product product

    int quantity

    String request

    static belongsTo = [order: Order]

}
