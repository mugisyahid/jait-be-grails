package com.jait.admin

import com.jait.CommonController
import com.jait.ProductOrder
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class ProductOrderController extends CommonController {

    static namespace = 'admin'

    def index() {
        respond(productOrders: ProductOrder.findAll())
    }

    def show(long id) {
        respond(productOrder: ProductOrder.findById(id))
    }

    def update(long id) {
        respond(productOrder: ProductOrder.findById(id))
    }

    def save(ProductOrder productOrder) {
        productOrder.validate()
        productOrder.save()
    }
}
