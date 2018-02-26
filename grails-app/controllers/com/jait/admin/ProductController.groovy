package com.jait.admin

import com.jait.CommonController
import com.jait.Product
import com.jait.ProductCategory
import com.jait.Store
import com.jait.command.api.ProductCommand
import grails.compiler.GrailsCompileStatic
import grails.converters.JSON

@GrailsCompileStatic
class ProductController extends CommonController {

    static namespace = 'admin'

    def index() {
        respond(products: Product.findAll())
    }

    def show(long id) {
        respond(product: Product.findById(id))
    }

    def update(long id) {
        respond(product: Product.findById(id))
    }

    def save(ProductCommand cmd) {
        if (!cmd.validate()) {
            return render(cmd.errors as JSON)
        }
        Product product = new Product(cmd)
        product.store = Store.findById(cmd.storeId)
        product.productCategory = ProductCategory.findById(cmd.productCategoryId)
        product.save()
        product.hasErrors() ? render(product.errors as JSON) : render(view: 'show', model: [product: product])
    }
}