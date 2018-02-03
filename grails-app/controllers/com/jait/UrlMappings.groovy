package com.jait

import static org.grails.web.mapping.DefaultUrlMappingEvaluator.*


class UrlMappings {

    static mappings = {

        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/index")
        "500"(view: '/error')
        "404"(view: '/notFound')

        '/register'(controller: 'user', action: 'register', method: "POST")

        group('/admin') {
            '/user'(resources: 'user', namespace: 'admin', includes: [ACTION_INDEX, ACTION_SHOW, ACTION_UPDATE, ACTION_SAVE])
            '/user/profile'(controller: 'user', action: 'profile', method: "POST")
            '/user/enableUser'(controller: 'user', action: 'enableUser', method: "PUT")

            '/role'(resources: 'role', namespace: 'admin', includes: [ACTION_INDEX])

            '/order'(resources: 'order', namespace: 'admin', includes: [ACTION_INDEX, ACTION_SHOW, ACTION_UPDATE, ACTION_SAVE])
            '/productOrder'(resources: 'productOrder', namespace: 'admin', includes: [ACTION_INDEX, ACTION_SHOW, ACTION_UPDATE, ACTION_SAVE])

        }

        group('/api') {
            '/product'(resources: 'product', namespace: 'api', includes: [ACTION_INDEX, ACTION_SHOW, ACTION_UPDATE, ACTION_SAVE])
            '/promo'(resources: 'promo', namespace: 'api', includes: [ACTION_INDEX, ACTION_SHOW, ACTION_UPDATE, ACTION_SAVE])
        }
    }
}
