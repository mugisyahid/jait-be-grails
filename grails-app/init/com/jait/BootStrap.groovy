package com.jait

class BootStrap {

    BootStrapService bootStrapService

    def init = { servletContext ->
        bootStrapService.appInit()
    }


    def destroy = {
    }
}
