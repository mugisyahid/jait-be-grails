package com.jait.admin

import com.jait.CommonController
import com.jait.Order

/**
 * Created by zeldris on 25/12/17.
 */
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
