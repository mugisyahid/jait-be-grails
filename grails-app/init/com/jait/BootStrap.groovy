package com.jait

import com.jait.service.BootStrapService

class BootStrap {

    BootStrapService bootStrapService

    def init = { servletContext ->
        bootStrapService.appInit()
    }


    def destroy = {
    }
}
