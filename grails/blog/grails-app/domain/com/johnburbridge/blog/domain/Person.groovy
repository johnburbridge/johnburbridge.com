package com.johnburbridge.blog.domain

/**
 * @author jburbridge
 * @since 11/25/2011
 */
class Person {

	String firstName;
	String lastName;
	String email;
	String bio;

	static hasMany = [posts: Post];	
	
    static constraints = {
		firstName blank: false;
		lastName blank: false;
		email blank: false;
		bio blank: true, maxSize: 1000; 
    }
	
	String toString() {	
		"${firstName} ${lastName} <${email}>";
	}
}
