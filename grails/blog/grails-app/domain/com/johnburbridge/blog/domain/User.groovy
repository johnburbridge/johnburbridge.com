package com.johnburbridge.blog.domain

/**
* @author jburbridge
* @since 11/27/2011
*/
class User extends Person {

	String userName;
	String password;

    static constraints = {
		userName blank: false, unique: true;
		password blank: false;
    }
	
	String toString() {
		userName;
	}
}
