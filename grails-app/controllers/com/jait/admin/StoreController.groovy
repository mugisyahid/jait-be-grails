package com.jait.admin

import com.jait.CommonController
import com.jait.Store
import grails.compiler.GrailsCompileStatic
import grails.plugin.springsecurity.SpringSecurityService

@GrailsCompileStatic
class StoreController extends CommonController {

    static namespace = 'admin'

    SpringSecurityService springSecurityService

    def index() {
        def user = springSecurityService.currentUser
        respond(store: Store.findByUser(user)) // only one store per user
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
