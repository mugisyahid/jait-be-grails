package com.jait.admin

import com.jait.CommonController
import com.jait.Store
import com.jait.User
import grails.compiler.GrailsCompileStatic
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

@GrailsCompileStatic
@Secured('IS_AUTHENTICATED_FULLY')
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
        def user = springSecurityService.currentUser
        store.user = (User) user
        store.validate()
        store.save()
    }
}
