package com.test.security.admin

import grails.plugins.rest.client.RestBuilder
import grails.testing.mixin.integration.Integration
import spock.lang.Specification

/**
 * Created by zeldris on 23/12/17.
 */
@Integration
class UserApiSpec extends Specification {

    def 'test /admin/user url is secured'() {
        given:
        RestBuilder rest = new RestBuilder()

        when:
        def resp = rest.get("http://localhost:${serverPort}/admin/user") {
            accept('application/json')
            contentType('application/json')
        }

        then:
        resp.json.status == 403
        resp.json.error == 'Forbidden'
        resp.json.message == 'Access is denied'
        resp.json.path == '/admin/user'
    }

}
