package com.jait.admin

import com.jait.CommonController
import com.jait.Role
import grails.compiler.GrailsCompileStatic
import grails.plugin.springsecurity.annotation.Secured

@GrailsCompileStatic
@Secured('IS_AUTHENTICATED_FULLY')
class RoleController extends CommonController {

    static namespace = 'admin'

    def index() {
        respond(roles: Role.findAll())
    }
}