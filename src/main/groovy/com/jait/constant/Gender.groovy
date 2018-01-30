package com.jait.constant

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
enum Gender {
    MALE('Male'),
    FEMALE('Female')

    String display

    Gender(String display) {
        this.display = display
    }
}
