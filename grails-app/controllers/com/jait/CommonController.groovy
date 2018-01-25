package com.jait

import grails.compiler.GrailsCompileStatic
import org.springframework.context.MessageSource
import org.springframework.http.HttpMethod
import org.springframework.validation.Errors

@GrailsCompileStatic
abstract class CommonController {

    static allowedMethods = [index : HttpMethod.GET.name(), show: HttpMethod.GET.name(),
                             save  : HttpMethod.POST.name(), update: HttpMethod.PUT.name(),
                             delete: HttpMethod.DELETE.name()]

    static responseFormats = ['json']

    MessageSource messageSource

    protected List getErrors(Object obj) {
        Errors errors = obj.hasProperty('errors') ? obj['errors'] as Errors : null
        errors?.allErrors?.collect { messageSource.getMessage(it, null) } ?: []
    }
}
