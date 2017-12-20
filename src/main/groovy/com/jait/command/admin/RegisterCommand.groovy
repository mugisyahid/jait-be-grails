package com.jait.command.admin

import grails.validation.Validateable

class RegisterCommand implements Validateable {

    String username
    String password
    String name
    String remark
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
    List<String> roles
}
