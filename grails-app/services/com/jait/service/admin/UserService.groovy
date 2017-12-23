package com.jait.service.admin

import com.jait.Role
import com.jait.User
import com.jait.UserRole
import com.jait.command.admin.RegisterCommand
import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.SpringSecurityService

@Transactional
@GrailsCompileStatic
class UserService {

    SpringSecurityService springSecurityService

    User register(RegisterCommand cmd) {
        User user = new User(name: cmd.name, username: cmd.username, password: cmd.password, remark: cmd.remark)
        user.save()
        setRole(user, cmd.roles)
        user
    }

    void setRole(User user, List<String> roles){
        roles.each {
            Role role = Role.findByAuthority(it)
            UserRole.create(user, role)
        }
    }
}