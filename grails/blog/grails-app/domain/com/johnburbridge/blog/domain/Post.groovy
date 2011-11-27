package com.johnburbridge.blog.domain

/**
 * @author jburbridge
 * @since 11/25/2011
 */
class Post {

	String title;
	Person author;
	Date postedDate;
	String body;
	
	static belongsTo = Person;
	
    static constraints = {
		title blank: false;
		author blank: false;
		postedDate blank: false;
		body blank: false, maxSize: 5000;
    }
	
	String toString() {
		"${title} - [${postedDate}]";
	}
}
