package com.jait.admin

import com.jait.CommonController
import com.jait.Store
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class StoreController extends CommonController {

    static namespace = 'admin'

    def index() {
        respond(stores: Store.findAll())
    }

    def show(long id) {
        respond(store: Store.findById(id))
    }

    def update(long id) {
        respond(store: Store.findById(id))
    }

    def save(Store store) {
        store.validate()
        store.save()
    }
}
