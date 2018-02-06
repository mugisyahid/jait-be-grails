package com.jait.constant

import groovy.transform.CompileStatic

@CompileStatic
enum FileType {
    IMAGE('Image'),
    DOCS('Docs'),
    VIDEO('Video'),
    MUSIC('Music'),
    OTHER('Other')

    String display

    FileType(String display) {
        this.display = display
    }
}
