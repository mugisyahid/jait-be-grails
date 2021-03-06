package com.jait

class Order {

    String number

    static belongsTo = [customer: User]

    static hasMany = [productOrders: ProductOrder]

    static constraints = {
    }

    static mapping = {
        //https://stackoverflow.com/questions/27987068/spring-boot-hibernate-syntax-error-in-sql-statement
        table 'order_table'
    }
}
