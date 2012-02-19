package com.johnburbridge.blog

import com.johnburbridge.security.SecurityUser

/**
 * @author jburbridge
 * @since 11/27/2011
 */
class User extends SecurityUser {

    String firstName;
    String lastName;
    String email;
    String bio;

    static hasMany = [posts: Post];    
    
    static constraints = {
        firstName blank: false, maxSize: 20;
        lastName blank: false, maxSize: 20;
        email email: true, blank: true;
        bio blank: true, maxSize: 1000; 
    }
    
    String toString() {    
        "${firstName} ${lastName} <${email}>";
    }
}
