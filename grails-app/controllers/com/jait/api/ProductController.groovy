package com.jait.api

import com.jait.CommonController
import com.jait.Product
import com.jait.User
import com.jait.command.api.ProductCommand
import grails.compiler.GrailsCompileStatic
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import org.joda.time.LocalDateTime

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

    //any role
    @Secured("(['ROLE_SYSTEM', 'ROLE_ADMIN', 'ROLE_CUSTOMER'])")
    def save(ProductCommand cmd) {
        if (!cmd.validate()) {
            return render(cmd.errors as JSON)
        }
        Product product = new Product(cmd)
        product.user = User.findById(cmd.userId)
        product.hasErrors() ? render(product.errors as JSON) : render(view: 'show', model: [product: product])
    }
}