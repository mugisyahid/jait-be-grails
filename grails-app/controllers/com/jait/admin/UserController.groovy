package com.jait.admin

import com.jait.CommonController
import com.jait.User
import com.jait.command.admin.RegisterCommand
import com.jait.service.admin.UserService
import com.jait.service.file.ImageService
import grails.compiler.GrailsCompileStatic
import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import org.grails.web.json.JSONObject
import org.springframework.http.HttpMethod
import sun.misc.BASE64Decoder

import static org.springframework.http.HttpStatus.NOT_FOUND

@GrailsCompileStatic
class UserController extends CommonController {

    static namespace = 'admin'

    static allowedMethods = [register  : HttpMethod.POST.name(), profile: HttpMethod.POST.name(),
                             enableUser: HttpMethod.PUT.name(), updateImage: HttpMethod.POST.name()]

    UserService userService
    ImageService imageService
    SpringSecurityService springSecurityService

    @Secured('IS_AUTHENTICATED_ANONYMOUSLY')
    def register(RegisterCommand cmd) {
        if (!cmd.validate()) {
            return render(cmd.errors as JSON)
        }
        User user = userService.register(cmd)
        userService.setRole(user, cmd.roles)
        user.hasErrors() ? render(user.errors as JSON) : render(view: 'show', model: [user: user])
    }

    @Secured(['ROLE_SYSTEM', 'ROLE_ADMIN'])
    def index() {
        def id = springSecurityService.getCurrentUserId()
        respond(users: User.findAll("from User as U where U.id not in (?) ", [id]))
    }

    @Secured('IS_AUTHENTICATED_FULLY')
    def show(long id) {
        respond(user: User.findById(id))
    }

    @Secured('IS_AUTHENTICATED_FULLY')
    def profile(User cmd) {
        render(view: 'show', model: [user: User.findByUsername(cmd.username)])
    }

    @Secured('IS_AUTHENTICATED_FULLY')
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

    @Secured('IS_AUTHENTICATED_FULLY')
    @Transactional
    def save(User user) {
        user.validate()
        user.save(flush: true)
        render(view: 'show', model: [user: user])
    }

    @Secured('IS_AUTHENTICATED_FULLY')
    @Transactional
    def enableUser() {
        def json = request.getJSON() as JSONObject
        def user = User.findById(json.get('id'))
        user.enabled = !user.enabled
        user.save()
        render(view: 'show', model: [user: user])
    }

    @Secured('IS_AUTHENTICATED_FULLY')
    @Transactional
    def updateImage() {
        def json = request.getJSON() as JSONObject
        User user = User.findById(json.get('id'))
        if (user.image) {
            //delete existing, failed because string to sign
            //Invalid Signature 1981081d763b716454a1c17df0537f4365c63a1c. String to sign - 'invalidate=false&public_id=user/vojwluofllejd0axbhzg&timestamp=1518098033'.
            //if(user.image.get(0)) imageService.delete(user.image.get(0), [:])
        }
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] imageByte = decoder.decodeBuffer((String) json.get('value'));
        user.image = imageService.upload(imageByte, ['folder': 'user/', 'resource_type': 'image'])
        user.save()
        return user.image.get(1) //url
    }
}