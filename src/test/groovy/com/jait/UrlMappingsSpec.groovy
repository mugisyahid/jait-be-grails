package com.jait

import com.jait.admin.UserController
import grails.testing.web.UrlMappingsUnitTest
import spock.lang.Specification
import spock.lang.Unroll


class UrlMappingsSpec extends Specification implements UrlMappingsUnitTest<UrlMappings> {

    @Unroll
    void "test url mappings #urls"() {
        given: 'mocked controller'
        mockController(UserController)

        expect:
        assertUrlMapping(maps, urls)

        where:
        urls        | maps
//        '/'  | [controller: 'application', action: 'index', method: 'GET']
        '/register' | [controller: 'user', action: 'register', method: "POST"]


    }
}