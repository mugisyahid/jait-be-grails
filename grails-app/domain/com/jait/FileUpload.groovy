package com.jait

import com.jait.constant.FileType

class FileUpload {

    String file //base64
    Integer version
    String name
    String extention
    FileType fileType
    String contentType

    static constraints = {
        file nullable: false
        version nullable: true
        name nullable: false
        extention nullable: false
        fileType nullable: false
        contentType nullable: false
    }

    static mapping = {
    }

}
