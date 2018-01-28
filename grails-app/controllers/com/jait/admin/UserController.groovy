package com.jait.admin

import com.jait.CommonController
import com.jait.User
import com.jait.command.admin.RegisterCommand
import com.jait.service.admin.UserService
import grails.compiler.GrailsCompileStatic
import grails.converters.JSON
import org.springframework.http.HttpMethod

import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK

@GrailsCompileStatic
class UserController extends CommonController {

    static namespace = 'admin'

    static allowedMethods = [register: HttpMethod.POST.name(), profile: HttpMethod.POST.name()]

    UserService userService

    def index() {
        respond(users: User.findAll())
    }

    def show(long id) {
        respond(user: User.findById(id))
    }

    def profile(User cmd) {
        render(view: 'show', model: [user: User.findByUsername(cmd.username)])
    }

    def update(User user) {
        if (user == null) {
            render status: NOT_FOUND
            return
        }

        if (user.hasErrors()) {
            respond user.errors, view: 'show'
            return
        }

        save(user)
    }

    def save(User user) {
        user.validate()
        user.save()
        render(view: 'show', model: [user: user)])
    }


    def register(RegisterCommand cmd) {
        if (!cmd.validate()) {
            return render(cmd.errors as JSON)
        }
        User user = userService.register(cmd)
        userService.setRole(user, cmd.roles)
        user.hasErrors() ? render(user.errors as JSON) : render(view: 'show', model: [user: user])
    }
}