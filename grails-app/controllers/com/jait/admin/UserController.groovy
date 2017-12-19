package com.jait.admin

import com.jait.CommonController
import com.jait.User
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class UserController extends CommonController {

    static namespace = 'admin'

    def index() {
        respond(userList: User.findAll())
    }

    def show(long id) {
        respond(user: User.findById(id))
    }

    def update(long id) {

    }

    def save(User user) {
        user.validate()
        user.save()
    }
}