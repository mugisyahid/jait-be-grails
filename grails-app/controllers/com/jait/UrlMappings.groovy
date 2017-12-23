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

       group('/admin'){
           '/user'(resources: 'user', namespace: 'admin', includes: [ACTION_INDEX, ACTION_SHOW, ACTION_UPDATE, ACTION_SAVE])
           '/role'(resources: 'role', namespace: 'admin', includes: [ACTION_INDEX])
       }
    }
}
