package com.johnburbridge.blog.domain

/**
 * @author jburbridge
 * @since 11/125/2011
 */
class Person {

	String firstName;
	String lastName;
	String userName;

	static hasMany = [posts: Post];	
	
    static constraints = {
		firstName blank: false;
		lastName blank: false;
		userName blank: false, unique: true;
    }
}
