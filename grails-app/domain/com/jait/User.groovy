package com.jait

import com.jait.constant.Gender
import com.jait.constant.Status
import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@GrailsCompileStatic
@EqualsAndHashCode(includes = 'username')
@ToString(includes = 'username', includeNames = true, includePackage = false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String username
    String password
    String name
    String remark
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    //simple object
    String phone
    String about
    Long registered
    List<String> image //public_id and url

    //entity
    Gender gender
    Status status

    //relation
    static hasOne = [store: Store]

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
        phone nullable: true, blank: true
        about nullable: true, blank: true
        image nullable: true, blank: true
        gender nullable: true, blank: true
        store nullable: true, blank: true, unique: true
    }

    static mapping = {
        password column: '`password`'
    }
}
