package com.jait.api

import com.jait.CommonController
import com.jait.Product
import grails.compiler.GrailsCompileStatic

/**
 * Created by zeldris on 25/12/17.
 */
@GrailsCompileStatic
class ProductController extends CommonController {

    static namespace = 'api'

    def index() {
        respond(products: Product.findAll())
    }

    def show(long id) {
        respond(product: Product.findById(id))
    }

    def update(long id) {
        respond(product: Product.findById(id))
    }

    def save(Product product) {
        product.validate()
        product.save()
    }

}