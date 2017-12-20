package com.jait.admin

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
        //setPassword(user, cmd.password)
        //setRole(user, cmd.roles)
        user.save() ?: user
    }

    void setPassword(User user, String password) {
        user.password = springSecurityService.encodePassword(password)
    }

    void setRole(User user, List<String> roles){
        roles.each {
            Role role = Role.findByAuthority(it)
            UserRole userRole = new UserRole(user: user, role: role)
            userRole.save() ?: log.warn(userRole.errors as String)
        }
    }
}