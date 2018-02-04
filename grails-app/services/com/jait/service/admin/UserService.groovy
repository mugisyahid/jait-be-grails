package com.jait.service.admin

import com.jait.Role
import com.jait.User
import com.jait.UserRole
import com.jait.command.admin.RegisterCommand
import com.jait.constant.Status
import grails.compiler.GrailsCompileStatic
import grails.gorm.transactions.Transactional
import org.joda.time.LocalDateTime


@Transactional
@GrailsCompileStatic
class UserService {

    User register(RegisterCommand cmd) {
        User user = new User(name: cmd.name, username: cmd.username, password: cmd.password, remark: cmd.remark)
        user.status = Status.ACTIVE
        user.registered = new LocalDateTime().toDate().getTime()
        user.save() ?: user
    }

    void setRole(User user, List<String> roles) {
        roles.each {
            Role role = Role.findByAuthority(it)
            UserRole.create(user, role)
        }
    }
}