package com.jait.admin

import com.jait.CommonController
import com.jait.Order
import grails.compiler.GrailsCompileStatic
import grails.plugin.springsecurity.annotation.Secured

@GrailsCompileStatic
@Secured('IS_AUTHENTICATED_FULLY')
class OrderController extends CommonController {

    static namespace = 'admin'

    def index() {
        respond(orders: Order.findAll())
    }

    def show(long id) {
        respond(order: Order.findById(id))
    }

    def update(long id) {
        respond(order: Order.findById(id))
    }

    def save(Order order) {
        order.validate()
        order.save()
    }
}
