package com.jait.admin

import com.jait.CommonController
import com.jait.Role
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class RoleController extends CommonController {

    static namespace = 'admin'

    def index() {
        respond(roles: Role.findAll())
    }
}