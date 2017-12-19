package com.jait

import static org.grails.web.mapping.DefaultUrlMappingEvaluator.*


class UrlMappings {

    static mappings = {
       /* "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }
        */

        "/"(view: "/index")
        "500"(view: '/error')
        "404"(view: '/notFound')

        /* security plugin */
        "/login/$action?"(controller: "login")
        "/logout/$action?"(controller: "logout")

       group('/admin'){
           '/user'(resources: 'user', namespace: 'admin', includes: [ACTION_INDEX, ACTION_SHOW, ACTION_UPDATE, ACTION_SAVE])
       }
    }
}
