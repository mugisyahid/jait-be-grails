package com.jait.admin

import com.jait.CommonController
import com.jait.ProductCategory
import grails.compiler.GrailsCompileStatic
import grails.plugin.springsecurity.annotation.Secured

@GrailsCompileStatic
@Secured('IS_AUTHENTICATED_FULLY')
class ProductCategoryController extends CommonController {

    static namespace = 'admin'

    def index() {
        respond(productCategories: ProductCategory.findAll())
    }

    def show(long id) {
        respond(productCategory: ProductCategory.findById(id))
    }

    def update(long id) {
        respond(productCategory: ProductCategory.findById(id))
    }

    def save(ProductCategory productCategory) {
        productCategory.validate()
        productCategory.save()
    }

}
