package com.test.security.page

import geb.Page

/**
 * Created by zeldris on 23/12/17.
 */
class UserListingPage extends Page {

    static url = '/admin/user'

    static at = {
        $('#list-announcement').text()?.contains 'Announcement List'
    }
}
