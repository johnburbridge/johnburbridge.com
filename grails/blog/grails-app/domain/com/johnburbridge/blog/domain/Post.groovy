package com.johnburbridge.blog.domain

/**
 * @author jburbridge
 * @since 11/125/2011
 */
class Post {

	String postId;
	String title;
	String body;
	Date datePosted;
	
    static constraints = {
		postId blank: false, unique: true;
		title blank: false;
		body blank: false;
		datePosted blank: false;
    }
}
